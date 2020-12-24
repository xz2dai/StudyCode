package com.c611.classProject.web.servlet;

import com.c611.classProject.bean.UserInfo;
import com.c611.classProject.bean.UserInfoPage;
import com.c611.classProject.exception.UserInfoException;
import com.c611.classProject.service.IUserService;
import com.c611.classProject.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

/**
 * @author Akili
 * @date 2020/12/22 20:52
 * @software IntelliJ IDEA
 */
@WebServlet("/userSearchServlet")
public class UserSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //构建服务层接口对象
        IUserService IUserService = new UserServiceImpl();

        String id=req.getParameter("userID");

        try {
            UserInfoPage userInfoPage=IUserService.searchByID(id);

            //保存数据到request作用域中
            req.setAttribute("userInfoPage", userInfoPage);

            //分发转向
            req.getRequestDispatcher("/content/user.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
