package com.c611.classProject.service.impl;

import com.c611.classProject.bean.Orders;
import com.c611.classProject.bean.OrdersPage;
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
public class OrdersServiceImpl implements IOrdersService {
    private IOrdersDao ordersDao = new OrdersDaoImpl();

    @Override
    public List<Orders> selectByOrderID(int OrderID) throws SQLException {
        return ordersDao.selectByOrderID(OrderID);
    }

    @Override
    public List<Orders> selectAll() throws SQLException {
        return ordersDao.selectAll();
    }

    @Override
    public void addOrders(int OrderUserID, int OrdergoodID, String OrderDescribe, int OrderStatus) throws SQLException {
        ordersDao.addOrders(OrderUserID, OrdergoodID, OrderDescribe, OrderStatus);
    }

    @Override
    public void delOrdersByOrderID(int OrderID) throws SQLException {
        ordersDao.delOrdersByOrderID(OrderID);
    }

    @Override
    public void finishOrders(int OrderID) throws SQLException {
        ordersDao.finishOrders(OrderID);
    }

    @Override
    public OrdersPage getOrdersPage(int page, int size) throws SQLException {
        //构建OrdersPage对象
        OrdersPage ordersPage = new OrdersPage();

        //格式化page和size
        page = (page < 1) ? 1 : page;
        size = (size < 1) ? 4 : size;//size默认值是4

        //分页查询数据
        List<Orders> list = ordersDao.selectAll((page - 1) * size, size);

        //查询总数
        int totalCount =ordersDao.count();
        //计算总页数
        int totalPageCount = totalCount / size;

        if (totalCount % size != 0) {
            totalPageCount++;
        }

        ordersPage.setCurrentPage(page);
        ordersPage.setList(list);
        ordersPage.setPageSize(size);
        ordersPage.setTotalCount(totalCount);
        ordersPage.setTotalPageCount(totalPageCount);

        return ordersPage;
    }
}
