package net.hunau.goodsmanager.servlet;

import net.hunau.goodsmanager.biz.UserBiz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 禁用/启用用户servlet
 * author：yq
 * date：11-9
 */
public class FlagUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("userName");
        int flag = Integer.parseInt(request.getParameter("op"));
        boolean done =false;
        UserBiz userBiz = new UserBiz();
        done = userBiz.iscancelUser(username,flag);
        PrintWriter pw = response.getWriter();
        if(done){
            pw.print("<script>alert(\""+"启用成功!"+"\")</script>");
        }else{
            pw.print("<script>alert(\""+"启用失败!"+"\")</script>");
        }
        response.sendRedirect("/main.html");
    }
}
