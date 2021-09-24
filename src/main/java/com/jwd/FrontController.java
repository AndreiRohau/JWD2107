package com.jwd;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jwd.entity.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

public class FrontController extends HttpServlet {

    private static List<String> userNames = Arrays.asList("Andrei", "Varfalamei", "Putin", "Volodia");
    private static List<User> users = Arrays.asList(
            new User(1L, "Andrei", 17),
            new User(2L, "Varfal", 60),
            new User(3L, "Putin", 80));
    private static boolean isTrue = true;
    private static boolean isFalse = false;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doExecute(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doExecute(req, resp);
    }

    private void doExecute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isRequireForward = true;
        String uri = prepareUri(req);
        String result = req.getParameter("msg");
        req.setAttribute("result", result);
        req.setAttribute("isTrueParam", isTrue);
        req.setAttribute("isFalseParam", isFalse);

        processSessionParameter(req, result);
        isRequireForward = processLocale(req, resp);
        isRequireForward = processGetNameAsJson(req, resp);
        processCookies(req, resp);
        processContext(req, resp);
        processConfig(req, resp);

        if (isRequireForward) {
            req.getRequestDispatcher(uri + ".jsp").forward(req, resp);
        }
    }

    private boolean processGetNameAsJson(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        boolean isRequireForward = true;
        String command = req.getParameter("command");
        if ("getNamesAsJson".equals(command)) {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(users);
            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            out.print(json);
            out.flush();
            isRequireForward = false;
        }
        return isRequireForward;
    }

    private boolean processLocale(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        boolean isRequireForward = true;
        String command = req.getParameter("command");
        if ("locale".equals(command)) {
            String locale = req.getParameter("locale");
            req.getSession().setAttribute("locale", locale);
            isRequireForward = false;
            resp.sendRedirect("/main");
        }
        return isRequireForward;
    }

    private void processContext(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext context = getServletContext();
        System.out.println(context);
    }

    private void processConfig(HttpServletRequest req, HttpServletResponse resp) {
        ServletConfig config = getServletConfig();
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String name = initParameterNames.nextElement();
            String value = config.getInitParameter(name);
            System.out.println(name + " - " + value);
        }
    }

    private void processCookies(HttpServletRequest req, HttpServletResponse resp) {
        Cookie[] cookies = req.getCookies();

        Cookie cookie = new Cookie("test", "tc");
        resp.addCookie(cookie);
    }

    private void processSessionParameter(HttpServletRequest req, String result) {
        HttpSession session = req.getSession();
        session.getMaxInactiveInterval();
        if ("+".equals(result)) {
            session.setAttribute("sessionParameter", "ha-ha-ha");
            System.out.println("set session parameter");
        } else if ("-".equals(result)) {
            session.invalidate();
            System.out.println("invalidate session parameters");
        } else {
            System.out.println("nothing happened to session");
        }
    }

    private String prepareUri(HttpServletRequest req) {
        String uri = req.getRequestURI().replace("/", "");
        if (uri.isEmpty()) {
            uri = "home";
        }
        return uri;
    }

}
