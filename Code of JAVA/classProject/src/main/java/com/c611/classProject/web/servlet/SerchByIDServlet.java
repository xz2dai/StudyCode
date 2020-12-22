package com.c611.classProject.web.servlet;

import com.c611.classProject.bean.Orders;
import com.c611.classProject.service.IOrdersService;
import com.c611.classProject.service.impl.IOrdersServiceImpl;

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
@WebServlet("/SerchByID")
public class SerchByIDServlet extends HttpServlet {

    //通过service接口创建serviceImpl对象
    private IOrdersService service=new IOrdersServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Orders> list = null;
        try {
            list = service.selectAll();
            req.setAttribute("list", list);
            req.getRequestDispatcher("/content/orders.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }





//        String inputStr=req.getParameter("input");
//        int input=Integer.getInteger(inputStr);
//        Orders orders=null;
//        int OrderID=0;
//        int OrderUserID=0;
//        String OrderDescribe=null;
//        int OrderStatus=0;
//        try {
//            //将前端获取到的表单信息通过service对象传给service,并收到返回数据
//            orders =service.selectByOrderID(input);
//            OrderID=orders.getOrderID();
//            OrderUserID=orders.getOrderUserID();
//            OrderDescribe=orders.getOrderDescribe();
//            OrderStatus=orders.getOrderStatus();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        if (orders==null){//查询失败
//            resp.sendRedirect("/content/orders.jsp");
//
//        }else {//查询成功
//            req.setAttribute("orders",orders);
//            req.setAttribute("OrderID",OrderID);
//            req.setAttribute("OrderUserID",OrderUserID);
//            req.setAttribute("OrderDescribe",OrderDescribe);
//            req.setAttribute("OrderStatus",OrderStatus);
//            req.getRequestDispatcher("/content/orders.jsp");


}
