package com.xz2dai.OA_demo.web.filter;


import com.xz2dai.OA_demo.bean.UserInfo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ：yq
 * @description：登陆过滤器
 * 访问content内内容的必须先登陆账号
 * @date ：2020/12/16 16:22
 */
@WebFilter(filterName = "LoginFilter",value = "/content/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession();

        Object userInfo = session.getAttribute("userInfo");
        if (userInfo != null) {
            //有用户数据证明登陆了，进入下一个过滤器
            doFilter(req, resp, filterChain);
        } else {
            //没有用户数据证明没有登陆，跳转到登陆页面
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
