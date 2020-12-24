package com.c611.classProject.web.servlet;

import com.c611.classProject.bean.Orders;
import com.c611.classProject.service.IOrdersService;
import com.c611.classProject.service.impl.OrdersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


/**
 * @author llz
 * @version 1.0
 * @date 2020/12/20 23:33
 */
@WebServlet("/OrdersSearch")
public class OrdersSearchServlet extends HttpServlet {

    private IOrdersService service = new OrdersServiceImpl();//通过service接口创建serviceImpl对象
    List<Orders> list = null;//创建用于接收结果集合

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //id=1  根据id搜索订单

            String inputStr=req.getParameter("input");

            int input = Integer.parseInt(inputStr);//得到的"input"为String类型需要转int

            try {
                //将前端获取到的表单信息通过service对象传给service,并收到返回数据
                list = service.selectByOrderID(input);

            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (list == null) {//查询无结果
                resp.sendRedirect("/OrdersList");

            } else {//查询成功
                req.setAttribute("list", list);
                req.getRequestDispatcher("/content/orders.jsp").forward(req, resp);
            }

    }
}
