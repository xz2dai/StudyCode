package net.hunau.goodsmanager.servlet;

import net.hunau.goodsmanager.bean.User;
import net.hunau.goodsmanager.biz.UserBiz;
import net.hunau.goodsmanager.utils.SaveInfoUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆servlet
 * 判断输入用户是否存在且密码是否正确，并返回登陆结果
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("userName");
        String password = req.getParameter("password");
        UserBiz userBiz = new UserBiz();
        User userbean=null;
        userbean = userBiz.login(username,password);
        if(userbean!=null){
            //返回用户信息
            SaveInfoUtils.saveSession(req,"UserInfo",userbean);
            RequestDispatcher view = req.getRequestDispatcher("/main.html");
            view.forward(req, resp);
        }else{
            RequestDispatcher view = req.getRequestDispatcher("/index.jsp");
            req.setAttribute("errorMessage","登陆失败，账户不存在或密码错误!");
            view.forward(req, resp);
        }

    }


}
