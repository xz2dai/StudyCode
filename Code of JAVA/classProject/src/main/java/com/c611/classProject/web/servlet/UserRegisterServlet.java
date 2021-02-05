package com.c611.classProject.web.servlet;

import com.c611.classProject.bean.UserInfo;
import com.c611.classProject.service.IUserService;
import com.c611.classProject.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author Akili
 * @date 2020/12/22 16:03
 * @software IntelliJ IDEA
 */
@WebServlet("/userRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决POST方式中文乱码问题
        req.setCharacterEncoding("UTF-8");

        // 得到表单数据的数据
        Map<String, String[]> map = req.getParameterMap();

        //创建一个封装的对象
        UserInfo userInfo = new UserInfo();


        try {
            // 使用BeanUtils工具包，将页面传递过来的参数和值【存在map中】，封装到userInfo这个对象中。
            BeanUtils.populate(userInfo, map);

            // 构建IUserInfoService接口对象
            IUserService IUserService = new UserServiceImpl();
            // 调用添加的方法
            IUserService.regisUserInfo(userInfo);
            //分发转向
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

