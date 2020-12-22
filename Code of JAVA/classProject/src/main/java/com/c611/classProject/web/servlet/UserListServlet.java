package com.c611.classProject.web.servlet;

import com.c611.classProject.bean.UserInfo;
import com.c611.classProject.exception.UserInfoException;
import com.c611.classProject.service.IUserService;
import com.c611.classProject.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * @author Akili
 * @date 2020/12/19 14:40
 * @software IntelliJ IDEA
 */
@WebServlet("/clientListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //构建服务层接口对象
        IUserService IUserService = new UserServiceImpl();

        try {

            //调用查询所有用户的方法
            List<UserInfo> userInfoList = IUserService.findAll();

            //保存集合数据到request作用域中
            req.setAttribute("userInfoList", userInfoList);

            //分发转向
            req.getRequestDispatcher("/content/user.jsp").forward(req, resp);

        } catch (UserInfoException e) {
            e.printStackTrace();
        }
    }


}
