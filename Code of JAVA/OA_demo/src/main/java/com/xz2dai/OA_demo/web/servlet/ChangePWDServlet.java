package com.xz2dai.OA_demo.web.servlet;

import com.xz2dai.OA_demo.bean.UserInfo;
import com.xz2dai.OA_demo.service.IUserInfoService;
import com.xz2dai.OA_demo.service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author ：yq
 * @description：TODO
 * @date ：2020/12/18 15:03
 */
@WebServlet("/ChangePWDServlet")
public class ChangePWDServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldpwd = req.getParameter("oldpwd");
        String newpwd = req.getParameter("newpwd");
        HttpSession session = req.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        String login_error = null;
        if(!oldpwd.equals(userInfo.getPassword())){ //原密码与用户密码不匹配
            login_error = "与原密码不符合!";
            req.setAttribute("login_error",login_error);
            req.getRequestDispatcher(req.getContextPath()+"/system/index/password.jsp").forward(req,resp);
        }else{
            IUserInfoService userInfoService = new UserInfoServiceImpl();
            boolean result = false;
            try {
                result = userInfoService.changePWD(userInfo.getId(),newpwd);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if(result){
                login_error = "修改成功！";
            }else{
                login_error = "修改失败";
            }
            req.setAttribute("login_error",login_error);
            req.getRequestDispatcher(req.getContextPath()+"/system/index/password.jsp").forward(req,resp);

        }

    }
}
