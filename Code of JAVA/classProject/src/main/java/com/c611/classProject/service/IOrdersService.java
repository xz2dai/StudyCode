package com.c611.classProject.service;

import com.c611.classProject.bean.Orders;

import java.sql.SQLException;
import java.util.List;

/**
 * @author llz
 * @version 1.0
 * @date 2020/12/20 19:47
 */
public interface IOrdersService {
    Orders selectByOrderID(int OrderID) throws SQLException;
    List <Orders> selectAll() throws SQLException;
}
