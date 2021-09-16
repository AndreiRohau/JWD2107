package com.jwd.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

    private static final String ENCODING_INIT_PARAM_NAME = "encoding";
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final String FILTERABLE_CONTENT_TYPE = "application/x-www-form-urlencoded";
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter(ENCODING_INIT_PARAM_NAME);
        if (encoding == null) {
            encoding = DEFAULT_ENCODING;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String contentType = request.getContentType();
        if (contentType != null && contentType.startsWith(FILTERABLE_CONTENT_TYPE)) {
            request.setCharacterEncoding(encoding);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
