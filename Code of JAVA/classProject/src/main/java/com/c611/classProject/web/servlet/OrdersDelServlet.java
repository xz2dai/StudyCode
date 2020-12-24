package com.c611.classProject.web.servlet;

import com.c611.classProject.service.IOrdersService;
import com.c611.classProject.service.impl.OrdersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author llz
 * @version 1.0
 * @date 2020/12/22 14:56
 */
@WebServlet("/OrdersDel")
public class OrdersDelServlet extends HttpServlet {

    private IOrdersService service = new OrdersServiceImpl();//通过service接口创建serviceImpl对象

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderID = req.getParameter("OrderID");
        int id = Integer.parseInt(orderID);     //得到的"OrderID"为String类型需要转int
        try {
            service.delOrdersByOrderID(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resp.sendRedirect("/OrdersList");
    }
}
