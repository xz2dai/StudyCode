package com.xz2dai.OA_demo.dao;

import com.xz2dai.OA_demo.bean.UserInfo;

import java.sql.SQLException;
import java.util.List;

public interface IUserInfoDao {

    /**
     * 通过用户名和密码查询用户信息
     *
     * @param account
     * @param password
     * @return
     * @throws SQLException
     *
     * @author yq
     * @date 2020年12月15日
     */
    UserInfo selectByAccountAndPwd(String account, String password) throws SQLException;

    /**
     * 添加用户信息
     *
     * @param userInfo
     * @return
     * @throws SQLException
     */
    boolean addUserInfo(UserInfo userInfo) throws SQLException;
    /**
     * 查询所有的用户信息
     *
     * @return
     * @throws SQLException
     */
    List<UserInfo> selectAll() throws SQLException;

    /**
     * 添加用户
     * @return
     * @throws SQLException
     */
    boolean addUser(UserInfo userInfo) throws SQLException;

    UserInfo findUserByID(String id) throws SQLException;

    boolean changePWD(String id,String pwd) throws SQLException;
}
