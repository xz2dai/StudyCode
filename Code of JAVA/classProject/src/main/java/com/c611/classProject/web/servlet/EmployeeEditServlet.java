package com.c611.classProject.web.servlet;


import com.c611.classProject.bean.EmployeeInfo;
import com.c611.classProject.service.IEmployeeService;
import com.c611.classProject.service.impl.IEmployeeServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/employeeEditServlet")
public class EmployeeEditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决POST方式中文乱码问题
        req.setCharacterEncoding("UTF-8");

        // 得到表单数据的数据
        Map<String,String[]> map = req.getParameterMap();

        //创建一个封装的对象
        EmployeeInfo employeeInfo = new EmployeeInfo();


        try {
            // 使用BeanUtils工具包，将页面传递过来的参数和值【存在map中】，封装到employeeInfo这个对象中。
            BeanUtils.populate(employeeInfo,map);

            // 构建IEmployeeService接口对象
            IEmployeeService IEmployeeService = new IEmployeeServiceImpl();

            // 调用添加的方法
            IEmployeeService.editEmployeeInfo(employeeInfo);

            //分发转向
            resp.sendRedirect(req.getContextPath() + "/employeeProfileServlet");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
