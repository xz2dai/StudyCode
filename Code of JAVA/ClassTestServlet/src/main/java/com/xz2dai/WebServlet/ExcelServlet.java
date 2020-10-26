package com.xz2dai.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ExcelServlet")
public class ExcelServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Content-Encoding", "utf-8");
        response.setContentType("application/msword;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("学号\t姓名\t性别\t年龄\t所在系");
        out.println("95001\t李勇\t男\t20\t信息");
        out.println("95002\t刘晨\t女\t19\t数学");
        }
    }

