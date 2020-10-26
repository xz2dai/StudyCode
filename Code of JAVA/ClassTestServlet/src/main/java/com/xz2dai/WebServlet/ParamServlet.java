package com.xz2dai.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ParamServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException{
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=gb2312");
        String name = request.getParameter("name");
        name = new String(name.getBytes("iso8859-1"),"gb2312");
        String age = request.getParameter("age");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>姓名："+name+"</h3><p>");
        out.println("<h3>年龄："+age+"</h3><p>");
        out.println("</body>");
        out.println("</html>");
    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException{
        doGet(request, response);
    }
}
