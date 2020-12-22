package com.c611.classProject.web.servlet;


import com.c611.classProject.exception.UserInfoException;
import com.c611.classProject.service.IUserService;
import com.c611.classProject.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Akili
 * @date 2020/12/20 23:00
 * @software IntelliJ IDEA
 */
@WebServlet("/userDelServlet")
public class UserDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取表单数据
        String id=req.getParameter("id");

        //构建服务层接口对象
        IUserService IUserService =new UserServiceImpl();


        try {
            //调用删除UserInfo对象方法
            boolean userInfo= IUserService.delUserInfoById(id);

            //将数据保存到requset的作用域中
            req.setAttribute("userInfo",userInfo);

            //分发转向
            req.getRequestDispatcher("/clientListServlet").forward(req,resp);

        } catch (UserInfoException e) {
            e.printStackTrace();
        }


    }
}
