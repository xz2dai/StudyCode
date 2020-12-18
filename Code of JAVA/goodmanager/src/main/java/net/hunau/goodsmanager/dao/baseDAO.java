package net.hunau.goodsmanager.dao;

import net.hunau.goodsmanager.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;


/**
 * 最基础的DAO，包含基础的连接与关闭方法
 * 内置一个connection对象，在初始化的时候就会从连接池中获取一个连接
 * */
public class baseDAO {
    protected static Connection connection = null;

    /**
     * 强制类加载时获取一个数据库连接池连接
     */
    static {
        try {
            connection = JDBCUtils.getConnection();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void close(){
        try {
            if(connection!=null) connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
