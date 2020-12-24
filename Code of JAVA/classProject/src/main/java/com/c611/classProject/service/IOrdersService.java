package com.c611.classProject.service;

import com.c611.classProject.bean.Orders;
import com.c611.classProject.bean.OrdersPage;

import java.sql.SQLException;
import java.util.List;

/**
 * @author llz
 * @version 1.0
 * @date 2020/12/20 19:47
 */
public interface IOrdersService {
    List<Orders> selectByOrderID(int OrderID) throws SQLException;
    List <Orders> selectAll() throws SQLException;
    OrdersPage getOrdersPage(int page, int size) throws SQLException;
    void addOrders(int OrderUserID, int OrdergoodID, String OrderDescribe, int OrderStatus) throws SQLException;
    void delOrdersByOrderID(int OrderID) throws SQLException;
    void finishOrders(int OrderID) throws SQLException;

}
