package com.c611.classProject.service.impl;

import com.c611.classProject.bean.UserInfo;
import com.c611.classProject.dao.IUserDao;
import com.c611.classProject.dao.impl.IUserDaoImpl;
import com.c611.classProject.exception.UserInfoException;
import com.c611.classProject.service.IUserService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Akili
 * @date 2020/12/19 14:51
 * @software IntelliJ IDEA
 */
public class UserServiceImpl implements IUserService {

private IUserDao IUserDao =new IUserDaoImpl();

    @Override
    public List<UserInfo> findAll() throws UserInfoException {
        try {
            return IUserDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserInfoException("查询所有用户信息失败");
        }
    }

    @Override
    public UserInfo getUserInfoById(String userId) throws UserInfoException {
        try {
            return IUserDao.getUserInfoById(userId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserInfoException("通过id查询用户信息失败...");
        }
    }

    @Override
    public boolean delUserInfoById(String userId) throws UserInfoException {
        try {
            return IUserDao.delUserInfoById(userId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new UserInfoException("通过id删除用户信息失败...");
        }
    }

    @Override
    public boolean editUserInfo(UserInfo userInfo) throws UserInfoException {
        try {
            return IUserDao.editUserInfo(userInfo);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new UserInfoException("通过id编辑用户信息失败...");
        }
    }
}
