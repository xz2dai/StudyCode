package com.c611.classProject.web.servlet;

import com.c611.classProject.Utils.StringUtils;
import com.c611.classProject.bean.Orders;
import com.c611.classProject.bean.OrdersPage;
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
 * @date 2020/12/22 14:57
 */
@WebServlet("/OrdersList")
public class OrdersListServlet extends HttpServlet {

    private IOrdersService service = new OrdersServiceImpl();//通过service接口创建serviceImpl对象


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获得表单数据
        String pageStr = req.getParameter("page");
        String sizeStr = req.getParameter("size");

        // 判断页码和页面显示的数量
        int page=1;//默认页码
        int size= 4; //默认显示的订单数
        if (!StringUtils.isEmpty(pageStr)) {
            try {
                page = Integer.parseInt(pageStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        if (!StringUtils.isEmpty(sizeStr)) {
            try {
                size = Integer.parseInt(sizeStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        try {
            // 分页查询
            OrdersPage ordersPage = service.getOrdersPage(page,size);
            List<Orders> list=ordersPage.getList();
            req.setAttribute("ordersPage", ordersPage);
            req.setAttribute("list", list);

            req.getRequestDispatcher("/content/orders.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
