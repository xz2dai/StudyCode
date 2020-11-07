package net.hunau.goodsmanager.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤输入格式过滤器，强制所有页面使用utf-8
 */
@WebFilter(filterName = "EncodeFilter",value = "/*")
public class EncodeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }
}
