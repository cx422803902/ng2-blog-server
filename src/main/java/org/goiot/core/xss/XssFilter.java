package org.goiot.core.xss;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by chenxing on 2017/5/30.
 */
@WebFilter(
        filterName = "xssFilter",
        urlPatterns = "/*",
        initParams = {
        @WebInitParam(name = "FilterChar", value = "@"),
        @WebInitParam(name = "ReplaceChar", value = "'@＜@‘@“@＼@＃@（@）"),
        @WebInitParam(name = "SplitChar", value = ">;<;@\\'@\\\"@\\\\@#@(@)]")})
public class XssFilter implements Filter {
    FilterConfig filterConfig = null;
    private String filterChar;
    private String replaceChar;
    private String splitChar;

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
