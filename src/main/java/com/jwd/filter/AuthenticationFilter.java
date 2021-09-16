package com.jwd.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (req.getParameter("command") != null && (
                req.getParameter("command").equals("logout") ||
                req.getParameter("command").equals("logination") ||
                req.getParameter("command").equals("registration") ||
                req.getParameter("command").equals("changeLanguage") ||
                req.getParameter("command").equals("goToSpecificPage") ||
                req.getSession().getAttribute("role") != null
                )) {
            chain.doFilter(req, resp);
        } else {
            resp.sendRedirect("/");
        }
    }

    @Override
    public void destroy() {
    }
}
