package com.c611.classProject.dao;

import com.c611.classProject.bean.UserInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Akili
 * @date 2020/12/19 14:58
 * @software IntelliJ IDEA
 */


public interface IUserDao {
    /**
     * 查询所有用户信息
     * @return
     * @throws SQLException
     */
    List<UserInfo> findAll() throws SQLException;

    /**
     *通过用户ID查询用户信息
     * @param id
     * @return
     * @throws SQLException
     */
    UserInfo getUserInfoById(String id) throws SQLException;

    /**
     *通过用户ID删除用户信息
     * @param id
     * @return
     * @throws SQLException
     */
    boolean delUserInfoById(String id) throws SQLException;

    /**
     * 用户注册
     * @param userInfo
     * @return
     * @throws SQLException
     */
    boolean regisUserInfo(UserInfo userInfo) throws SQLException;

    /**
     * 通过用户ID更改用户信息
     * @param userInfo
     * @return
     * @throws SQLException
     */
    boolean editUserInfo(UserInfo userInfo) throws SQLException;

    /**
     * 登录功能
     * @param name
     * @return
     * @throws SQLException
     */
    UserInfo loginUserInfo(String name) throws SQLException;

    /**
     *分页查询
     * @param page  数据表的行号
     * @param size 每页显示的条数
     * @return
     * @throws SQLException
     */
    List<UserInfo> findAll(int page,int size) throws SQLException;

    /**
     * 查询总条数
     * @return
     * @throws SQLException
     */
    int count() throws SQLException;
}
