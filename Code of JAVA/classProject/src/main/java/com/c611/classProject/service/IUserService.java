package com.c611.classProject.service;

import com.c611.classProject.bean.UserInfo;
import com.c611.classProject.bean.UserInfoPage;
import com.c611.classProject.exception.UserInfoException;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Akili
 * @date 2020/12/19 14:50
 * @software IntelliJ IDEA
 */



public interface IUserService {
    /**
     * 得到所有用户信息的业务
     *
     * @return
     * @throws UserInfoException
     */
    List<UserInfo> findAll() throws UserInfoException;


    /**
     *
     * 通过用户ID查找用户信息
     *
     * @param userId
     * @return
     * @throws UserInfoException
     */
    UserInfo getUserInfoById(String userId) throws UserInfoException;

    /**
     * 通过用户ID删除用户信息
     * @param userId
     * @return
     * @throws UserInfoException
     */
    boolean delUserInfoById(String userId) throws UserInfoException;

    /**
     * 通过用户ID更改用户信息
     * @param userInfo
     * @return
     * @throws UserInfoException
     */
    boolean editUserInfo(UserInfo userInfo) throws UserInfoException;

    /**
     * 用户注册
     * @param userInfo
     * @return
     * @throws UserInfoException
     */
    boolean regisUserInfo(UserInfo userInfo) throws UserInfoException;

    /**
     * 用户登录
     * @param name
     * @return
     * @throws UserInfoException
     */
    UserInfo loginUserInfo(String name)throws UserInfoException;

    /**
     *分页
     * @param page  数据表的行号
     * @param size 每页显示的条数
     * @return
     * @throws SQLException
     */
    UserInfoPage findAll(int page, int size) throws SQLException;

    /**
     * 分页查询
     * @param id
     * @return
     * @throws SQLException
     */
    UserInfoPage searchByID(String id) throws SQLException;
}
