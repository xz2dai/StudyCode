package com.c611.classProject.web.servlet;

import com.c611.classProject.bean.Goods;
import com.c611.classProject.bean.Orders;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * @author ：yq
 * @description：TODO
 * @date ：2020/12/21 0:49
 */
public class MakeOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        boolean done = false;
        Map<String,String[]> parammap =  req.getParameterMap();
//        String userid = parammap.get("")
        HttpSession session = req.getSession();
        List<Goods> selectList = (List<Goods>) session.getAttribute("selectList");
        if(selectList==null) {
            return;
        }
//        new Orders()

        PrintWriter pw = resp.getWriter();
        pw.print("<html><head>success_alert()</body></html>");
//        if(done){
//            pw.print("<script>success_alert()</script>");
//        }else{
//            pw.print("<script>alert(\""+"添加失败!"+"\")</script>");
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public static void makeMsg(){

    }
}
