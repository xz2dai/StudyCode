package com.c611.classProject.dao.impl;

import com.c611.classProject.Utils.C3P0Utils;
import com.c611.classProject.bean.Orders;
import com.c611.classProject.dao.IOrdersDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @author llz
 * @version 1.0
 * @date 2020/12/20 18:44
 */
public class OrdersDaoImpl implements IOrdersDao {

    //创建QueryRunner对象
    private QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

    //添加订单
    @Override
    public void addOrders(int OrderUserID, int OrdergoodID, String OrderDescribe, int OrderStatus) throws SQLException {
        String sql = "insert into orders(OrderUserID,OrdergoodID,OrderDescribe,OrderStatus) values (?,?,?,?)";
        runner.update(sql, OrderUserID, OrdergoodID, OrderDescribe, OrderStatus);

    }

    //修改订单状态
    @Override
    public void finishOrders(int OrderID) throws SQLException {
        String sql ="update orders set OrderStatus = 1 where OrderID = ?";
        runner.update(sql,OrderID);
    }

    //通过用户ID查找订单(7条订单)
    @Override
    public List<Orders> selectByOrderUserID(int OrderUserID) throws SQLException {

        String sql = "select * from orders where OrderUserID=? limit 0,6";
        return runner.query(sql, new BeanListHandler<Orders>(Orders.class), OrderUserID);
    }

    //删除订单
    @Override
    public void delOrdersByOrderID(int OrderID) throws SQLException {
        String sql="delete from orders where OrderID = ?";
        runner.update(sql,OrderID);
    }

    //通过订单ID搜索订单
    @Override
    public List<Orders> selectByOrderID(int OrderID) throws SQLException {
        String sql = "select * from orders where OrderID=?";
        return runner.query(sql, new BeanListHandler<Orders>(Orders.class), OrderID);
    }

    //展示五条订单
    @Override
    public List<Orders> selectFiveOreders() throws SQLException {
        String sql = "select * from orders limit 0,4";
        return runner.query(sql, new BeanListHandler<>(Orders.class));
    }

    @Override
    public int count() throws SQLException {
        //定义sql语句
        String sql="select count(OrderID) from orders";
        // 执行DQL操作【结果是单行单列】
        Long count = (Long)runner.query(sql, new ScalarHandler());
        return count.intValue();
    }

    //分页查询
    @Override
    public List<Orders> selectAll(int page, int size) throws SQLException {
        String sql = "select * from orders limit ?,?";
        Object[] params = { page, size };
        return runner.query(sql, new BeanListHandler<>(Orders.class),params);
    }

    //展示所有订单
    @Override
    public List<Orders> selectAll() throws SQLException {
        String sql = "select * from orders";
        return runner.query(sql, new BeanListHandler<>(Orders.class));
    }

    //测试
    public static void main(String[] args) throws SQLException {
        List list = new OrdersDaoImpl().selectByOrderUserID(1);
        System.out.println(list);
    }
}
