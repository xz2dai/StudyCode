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
    Orders selectByOrderID(int OrderID) throws SQLException;
    List<Orders> selectAll() throws SQLException;
}
