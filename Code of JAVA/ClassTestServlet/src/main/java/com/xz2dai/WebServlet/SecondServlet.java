package com.xz2dai.WebServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SecondServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException{
        Student stud = (Student)request.getAttribute("stud");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<center>");
        out.println("学号："+stud.getSno()+"<br>");
        out.println("姓名："+stud.getSname()+"<br>");
        out.println("<a href=\"/helloweb/input.html\">返回输入页面</a>");
        out.println("</center>");
        out.println("</body></html>");
    }
}
