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
import java.util.List;

    //IEmployeeService IEmployeeService =  new IEmployeeServiceImpl();
@WebServlet("/employeeListServlet")
public class EmployeeListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //构建服务层接口对象
        IEmployeeService IEmployeeService = new IEmployeeServiceImpl();

        try {

            //调用查询所有用户的方法
            List<EmployeeInfo> employeeInfoList = IEmployeeService.getEmployeeListALL();

            //保存集合数据到request作用域中
            req.setAttribute("employeeInfoList",employeeInfoList);

            //分发转向
            req.getRequestDispatcher("/content/employee.jsp").forward(req,resp);

        } catch (EmployeeInfoException e) {
            e.printStackTrace();
        }



    }
}
