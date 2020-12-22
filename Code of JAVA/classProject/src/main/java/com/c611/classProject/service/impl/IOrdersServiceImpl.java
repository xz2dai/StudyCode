package com.c611.classProject.service.impl;

import com.c611.classProject.bean.Orders;
import com.c611.classProject.dao.IOrdersDao;
import com.c611.classProject.dao.impl.OrdersDaoImpl;
import com.c611.classProject.service.IOrdersService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author llz
 * @version 1.0
 * @date 2020/12/20 19:58
 */
public class IOrdersServiceImpl implements IOrdersService {
    private IOrdersDao ordersDao=new OrdersDaoImpl();
    @Override
    public Orders selectByOrderID(int OrderID) throws SQLException {
        return ordersDao.selectByOrderID(OrderID);
    }

    @Override
    public List<Orders> selectAll() throws SQLException {
        return ordersDao.selectAll();
    }
}
