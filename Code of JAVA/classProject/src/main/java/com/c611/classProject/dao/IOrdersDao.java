package com.c611.classProject.dao;

import com.c611.classProject.bean.Orders;

import java.sql.SQLException;
import java.util.List;

/**
 * @author llz
 * @version 1.0
 * @date 2020/12/20 19:55
 */
public interface IOrdersDao {
    List<Orders> selectByOrderID(int OrderID) throws SQLException;
    List<Orders> selectAll() throws SQLException;
    List<Orders> selectAll(int page,int size) throws SQLException;
    void addOrders(int OrderUserID, int OrdergoodID, String OrderDescribe, int OrderStatus) throws SQLException;
    void delOrdersByOrderID(int OrderID) throws SQLException;
    void finishOrders(int OrderID) throws SQLException;
    List<Orders> selectByOrderUserID(int OrderUserID) throws SQLException;
    public List<Orders> selectFiveOreders() throws SQLException;
    public int count() throws SQLException;
}
