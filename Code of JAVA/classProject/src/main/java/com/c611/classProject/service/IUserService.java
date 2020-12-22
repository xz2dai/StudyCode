package com.c611.classProject.service;

import com.c611.classProject.bean.UserInfo;
import com.c611.classProject.exception.UserInfoException;

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
}
