package com.xz2dai.OA_demo.web.servlet;

import com.xz2dai.OA_demo.bean.UserInfo;
import com.xz2dai.OA_demo.exception.UserInfoException;
import com.xz2dai.OA_demo.service.IUserInfoService;
import com.xz2dai.OA_demo.service.impl.UserInfoServiceImpl;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ：yq
 * @description：获取所有用户信息
 * @date ：2020/12/17 11:23
 */
@WebServlet("/getUserInfoList")
public class GetUserInfoServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IUserInfoService userInfoService = new UserInfoServiceImpl();
        try {
            //调用service对象查询数据
            List<UserInfo> userInfoList = userInfoService.getUserInfoList();
            req.setAttribute("userInfoList", userInfoList);
            req.getRequestDispatcher("/system/userList.jsp").forward(req,resp);
        } catch (UserInfoException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
