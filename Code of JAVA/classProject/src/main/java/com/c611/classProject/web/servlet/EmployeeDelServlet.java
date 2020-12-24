package com.c611.classProject.web.servlet;

import com.c611.classProject.exception.EmployeeInfoException;
import com.c611.classProject.service.IEmployeeService;
import com.c611.classProject.service.impl.IEmployeeServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employeeDelServlet")
public class EmployeeDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取表单数据
        String id = req.getParameter("employeeID");
        //构建服务层接口对象
        IEmployeeService IEmployeeService = new IEmployeeServiceImpl();

        try {
            //调用删除employeeInfo对象方法
            boolean employeeInfo= IEmployeeService.delEmployeeInfoById(id);

            //将数据保存到requset的作用域中
            req.setAttribute("employeeInfo", employeeInfo);

            //分发转向
            req.getRequestDispatcher("/employeeListServlet").forward(req,resp);

        } catch (EmployeeInfoException e) {
            e.printStackTrace();
        }
    }
}
