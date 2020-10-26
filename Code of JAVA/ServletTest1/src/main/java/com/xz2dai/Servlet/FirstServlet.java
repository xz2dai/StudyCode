package com.xz2dai.Servlet;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("用户名："+username);
        System.out.println("密码："+password);
        String[] hobbys = req.getParameterValues("hobby");
        System.out.print("爱好：");
        if(hobbys.length != 0){
            for (String hobby : hobbys) System.out.print(hobby + ",");
            System.out.print("\n");
        }else{
             System.out.print("null\n");
        }

        String lastAccessTime = null;
        Cookie[] cookies = req.getCookies();
        for(int i = 0;cookies!=null && i<cookies.length;i++){
            if("lastAccess".equals(cookies[i].getName())){
                lastAccessTime = cookies[i].getValue();
                break;
            }
        }
        if(lastAccessTime == null){
            resp.getWriter().println("您是首次访问本网站，欢迎您！");
        }else{
            resp.getWriter().println("您上次访问时间为："+lastAccessTime);
        }
        String currentTime = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
        Cookie cookie = new Cookie("lastAccess",currentTime);
        cookie.setMaxAge(60*60);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
