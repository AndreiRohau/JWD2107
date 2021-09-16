package com.jwd;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

public class FrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = prepareUri(req);
        String result = req.getParameter("msg");
        req.setAttribute("result", result);

        processSessionParameter(req, result);
        processCookies(req, resp);
        processContext(req, resp);
        processConfig(req, resp);

        req.getRequestDispatcher(uri + ".jsp").forward(req, resp);
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
