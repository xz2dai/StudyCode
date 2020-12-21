package com.c611.classProject.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yq
 * 最上层过滤器
 * 过滤输入输出格式过滤器，强制所有页面使用utf-8编码
 */
@WebFilter(filterName = "EncodeFilter",value = "/content/*")
public class EncodeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        String uri = req.getRequestURI();
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        if(uri.contains(".css") || uri.contains(".js") || uri.contains(".png"))
        {
            //response.setContentType("text/css;charset=utf-8");
        }
        else
        {
            //处理响应乱码
            resp.setContentType("text/html;charset=utf-8");
        }

        filterChain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }
}
