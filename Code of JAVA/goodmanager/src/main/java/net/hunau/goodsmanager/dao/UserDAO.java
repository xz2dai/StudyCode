package net.hunau.goodsmanager.dao;

import net.hunau.goodsmanager.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//�û���ز���DAO
public class UserDAO {
    private static Connection connection = null;
    static {
        JDBCUtils jdbc = new JDBCUtils();
        try {
            connection = jdbc.getConnection();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    /*
    �û���¼
    @param username �û���
    @param password �û�����
     */
    public boolean login(String username,String password) throws SQLException{
        PreparedStatement pstm = connection.prepareStatement("SELECT ");
        return false;
    }
}
