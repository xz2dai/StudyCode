package com.c611.classProject.web.servlet;

import com.c611.classProject.bean.EmployeeInfo;
import com.c611.classProject.exception.EmployeeInfoException;
import com.c611.classProject.service.IEmployeeService;
import com.c611.classProject.service.impl.IEmployeeServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employeeProfileServlet")
public class EmployeeProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取表单数据
        String id=req.getParameter("employeeID");

        //构建服务层接口对象
        IEmployeeService IEmployeeService = new IEmployeeServiceImpl();

        try {

            //调用通过用户id来获取用户信息的方法
            EmployeeInfo employeeInfo = IEmployeeService.getEmployeeInfoById(id);

            //将userInfo对象数据保存到request作用域中
            req.setAttribute("employeeInfo",employeeInfo);

            //分发转向
            req.getRequestDispatcher("/content/employeeprofile.jsp").forward(req,resp);
        } catch (EmployeeInfoException e) {
            e.printStackTrace();
        }
    }
}
