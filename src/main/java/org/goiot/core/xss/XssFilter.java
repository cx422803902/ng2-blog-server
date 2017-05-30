package org.goiot.core.xss;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by chenxing on 2017/5/30.
 */
public class XssFilter implements Filter {
    private String filterChar;
    private String replaceChar;
    private String splitChar;
    FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterChar = filterConfig.getInitParameter("FilterChar");
        this.replaceChar = filterConfig.getInitParameter("ReplaceChar");
        this.splitChar = filterConfig.getInitParameter("SplitChar");
        this.filterConfig = filterConfig;
    }

    public void destroy() {
        this.filterConfig = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new XssHttpServletRequestWrapper((HttpServletRequest) request,filterChar,replaceChar,splitChar), response);
    }
}
