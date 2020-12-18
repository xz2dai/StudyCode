package net.hunau.goodsmanager.servlet;

import net.hunau.goodsmanager.bean.User;
import net.hunau.goodsmanager.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 更新用户信息servlet
 */
@WebServlet("/UpdateUser")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("userName");
        String password = req.getParameter("password");
        int validateFlag = Integer.parseInt(req.getParameter("validateFlag"));
        int roleType = Integer.parseInt(req.getParameter("roleType"));

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setValidateFlag(validateFlag);
        user.setRoles(roleType);

        UserDAO userDAO = new UserDAO();
        boolean done =  userDAO.upUserData(user);
        PrintWriter pw = resp.getWriter();
        if(done){
            pw.print("<script>alert(\""+"更新成功!"+"\")</script>");
        }else{
            pw.print("<script>alert(\""+"更新失败!"+"\")</script>");
        }
        resp.sendRedirect("/main.html");
    }
}
