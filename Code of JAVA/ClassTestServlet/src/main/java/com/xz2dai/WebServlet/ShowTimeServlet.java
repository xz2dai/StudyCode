package com.xz2dai.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowTimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=gb2312");
        response.setHeader("refresh","2");
        PrintWriter out = response.getWriter();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
        String s = sdf.format(date);
        out.println("<html>");
        out.println("<body>");
        out.println("<h3 align=\"center\">每2秒钟刷新一次页面</h3><p>");
        out.println("<h3 align=\"center\">现在的时间是："+s+"</h3><p>");
        out.println("</body>");
        out.println("</html>");
    }
}
