package com.xz2dai.WebServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirstServlet extends HttpServlet {
    ServletContext context;
    public void init(){
        context = getServletContext();
    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String snumber = request.getParameter("snumber");
        String sname = request.getParameter("sname");
        Student stud = new Student(snumber,sname);
        request.setAttribute("stud",stud);
        RequestDispatcher view =
                request.getRequestDispatcher("/SecondServlet");
        view.forward(request, response);
    }
}
