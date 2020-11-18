package net.hunau.goodsmanager.servlet;

import net.hunau.goodsmanager.bean.User;
import net.hunau.goodsmanager.biz.UserBiz;
import net.hunau.goodsmanager.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        String username = req.getParameter("userName");
        String password = req.getParameter("passWord");
        int validateFlag = 1;
        int roleType = Integer.parseInt(req.getParameter("roleType"));

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setValidateFlag(validateFlag);
        user.setRoles(roleType);

        boolean done =  userDAO.AddUser(user);
        PrintWriter pw = resp.getWriter();
        if(done){
            pw.print("<script>alert(\""+"更新成功!"+"\")</script>");
        }else{
            pw.print("<script>alert(\""+"更新失败!"+"\")</script>");
        }
        resp.sendRedirect("/main.html");
    }
}
