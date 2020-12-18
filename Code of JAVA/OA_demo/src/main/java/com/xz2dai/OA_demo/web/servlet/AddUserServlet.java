package com.xz2dai.OA_demo.web.servlet;

import com.xz2dai.OA_demo.bean.UserInfo;
import com.xz2dai.OA_demo.service.impl.UserInfoServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author ：yq
 * @description：添加用户servlet
 * @date ：2020/12/17 15:54
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserInfo userInfo = new UserInfo();
        UserInfoServiceImpl userInfoService = new UserInfoServiceImpl();
        Map<String, String[]> parameterMap = req.getParameterMap();
        try {
            BeanUtils.populate(userInfo,parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        try {
            userInfoService.addUser(userInfo);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath()+"/system/userList.jsp");
    }
}
