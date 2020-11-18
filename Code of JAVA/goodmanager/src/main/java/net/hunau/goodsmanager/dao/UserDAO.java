package net.hunau.goodsmanager.dao;

import net.hunau.goodsmanager.bean.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * 用户相关操作DAO
 */
public class UserDAO extends baseDAO {
    /**
     * 获取用户信息
     *
     * @param username 用户名
     * @return 返回登录是否成功
     **/
    public User getUser(String username){
        User userbean = null;
        try {
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM users where userName=?");
            pstm.setString(1, username);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                userbean = new User();
                userbean.setUsername(rs.getString("userName"));
                userbean.setPassword(rs.getString("pwd"));
                userbean.setRoles(rs.getInt("roles"));
                userbean.setValidateFlag(rs.getInt("validateFlag"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return userbean;
    }

    /**
     * 使用默认参数用户注册
     *
     * @param username 用户名
     * @param password 用户密码
     * @return 返回注册是否成功
     **/
    public boolean AddUser(String username, String password){
        return AddUser(username,password,1,1);
    }

    /**
     * 用户注册
     * @param username 用户名
     * @param password 用户密码
     * @param validateFlag 有效标识
     * @param roles 用户权限等级
     * @return 返回注册是否成功
     */
    public boolean AddUser(String username, String password, int validateFlag, int roles){
        String sql = "insert into users(userName, pwd,validateFlag,roles) values (?,?,?,?)";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, password);
            pstm.setInt(3, validateFlag);
            pstm.setInt(4, roles);
            int result = pstm.executeUpdate();
            if(result > 0){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean AddUser(User user){
        String sql = "insert into users(userName, pwd,validateFlag,roles) values (?,?,?,?)";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1,user.getUsername());
            pstm.setString(2, user.getPassword());
            pstm.setInt(3,user.getValidateFlag());
            pstm.setInt(4,user.getRoles());

            int result = pstm.executeUpdate();
            if(result > 0){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<User> getAllUsers(){
        ArrayList<User> userList = new ArrayList<>();
        String sql = "select * from users";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.executeQuery();
            ResultSet rs = pstm.getResultSet();
            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("userName"));
                user.setPassword(rs.getString("pwd"));
                user.setRoles(rs.getInt("roles"));
                user.setValidateFlag(rs.getInt("validateFlag"));
                userList.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return userList;
    }

    public boolean upUserData(User user){
        String sql = "update users set pwd=?,validateFlag=?,roles=? where userName=?";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, user.getPassword());
            pstm.setInt(2,user.getValidateFlag());
            pstm.setInt(3,user.getRoles());
            pstm.setString(4,user.getUsername());
            int result = pstm.executeUpdate();
            if(result > 0){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteUser(String username){
        String sql = "delete from users where userName=?";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, username);
            int result = pstm.executeUpdate();
            if(result > 0){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
