package com.c611.classProject.service.impl;

import com.c611.classProject.bean.UserInfo;
import com.c611.classProject.bean.UserInfoPage;
import com.c611.classProject.dao.IUserDao;
import com.c611.classProject.dao.impl.UserDaoImpl;
import com.c611.classProject.exception.UserInfoException;
import com.c611.classProject.service.IUserService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Akili
 * @date 2020/12/19 14:51
 * @software IntelliJ IDEA
 */
public class UserServiceImpl implements IUserService {

    private IUserDao IUserDao = new UserDaoImpl();

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

    @Override
    public boolean regisUserInfo(UserInfo userInfo) throws UserInfoException {
        try {
            return IUserDao.regisUserInfo(userInfo);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new UserInfoException("注册失败....");
        }
    }

    @Override
    public UserInfo loginUserInfo(String name) throws UserInfoException {
        try {
            return IUserDao.loginUserInfo(name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public UserInfoPage findAll(int page, int size) throws SQLException {
        UserInfoPage userInfoPage = new UserInfoPage();

        //格式化page和size
        page = page < 1 ? 1 : page;
        size = size < 1 ? 5 : size;

        try {


            List<UserInfo> userInfoList =this.IUserDao.findAll((page - 1) * size, size);

            //查询总数
            int totalCount =this.IUserDao.count();

            //计算总页数
            int totalPageCount = totalCount / size;
            if (totalCount % size != 0) {
                ++totalPageCount;
            }

            //将集合数据设置到userInfoPage对象中
            userInfoPage.setUserInfoList(userInfoList);
            //设置查询的总数
            userInfoPage.setTotalPageCount(totalCount);
            //设置总页数
            userInfoPage.setTotalPageCount(totalPageCount);
            //设置当前页码数量
            userInfoPage.setCurrentPage(page);
            //设置访问条数
            userInfoPage.setPageSize(size);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userInfoPage;
    }

    @Override
    public UserInfoPage searchByID(String id) throws SQLException {
        UserInfoPage userInfoPage = new UserInfoPage();
        List<UserInfo> userInfoList =new ArrayList<>();
        UserInfo userInfo=IUserDao.getUserInfoById(id);
        userInfoList.add(userInfo);
        userInfoPage.setUserInfoList(userInfoList);
        return userInfoPage;
    }


}
