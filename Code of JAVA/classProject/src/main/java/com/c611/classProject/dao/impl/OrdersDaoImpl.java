package com.c611.classProject.dao.impl;

import com.c611.classProject.Utils.C3P0Utils;
import com.c611.classProject.bean.Orders;
import com.c611.classProject.dao.IOrdersDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;


/**
 * @author llz
 * @version 1.0
 * @date 2020/12/20 18:44
 */
public class OrdersDaoImpl implements IOrdersDao {

    //创建QueryRunner对象
    private QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

    //
    public void test(int OrderUserID, int OrdergoodID, String OrderDescribe, int OrderStatus) throws SQLException {
        String sql = "insert into orders(OrderUserID,OrdergoodID,OrderDescribe,OrderStatus) values (?,?,?,?)";
        runner.update(sql, OrderUserID, OrdergoodID, OrderDescribe, OrderStatus);

    }



    //通过订单ID搜索订单
    @Override
    public Orders selectByOrderID(int OrderID) throws SQLException {
        String sql = "select OrderID,OrderUserID,OrdergoodID,OrderDescribe OrderStatus from orders where OrderID=?";

        return runner.query(sql, new BeanHandler<Orders>(Orders.class), OrderID);
    }

    //展示所有订单
    @Override
    public List<Orders> selectAll() throws SQLException {
        String sql = "select OrderID,OrderUserID,OrdergoodID,OrderDescribe OrderStatus from orders";
        return runner.query(sql, new BeanListHandler<>(Orders.class));
    }


    //测试
    public static void main(String[] args) throws SQLException {
        List list = new OrdersDaoImpl().selectAll();
        System.out.println(list);
    }
}
