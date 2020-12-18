package com.xz2dai.OA_demo.service.impl;

import com.xz2dai.OA_demo.bean.UserInfo;
import com.xz2dai.OA_demo.dao.impl.UserInfoDaoImpl;
import com.xz2dai.OA_demo.exception.UserInfoException;
import com.xz2dai.OA_demo.service.IUserInfoService;

import java.sql.SQLException;
import java.util.List;

/**UserInfoService接口实现类
 *
 * @author yq
 * @date 2020年12月15日
 */
public class UserInfoServiceImpl implements IUserInfoService {

    private UserInfoDaoImpl userInfoDao = new UserInfoDaoImpl();

    @Override
    public UserInfo login(String account, String password) {
        try {
            return userInfoDao.selectByAccountAndPwd(account, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserInfo> getUserInfoList() throws UserInfoException {
        try {
            // 调用持久层的方法
            return userInfoDao.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserInfoException("查询所有用户信息失败...");
        }
    }

    public boolean addUser(UserInfo userInfo) throws SQLException{
        return false;
    }

    @Override
    public UserInfo findUserByID(String id) throws UserInfoException, SQLException {
        return userInfoDao.findUserByID(id);
    }

    @Override
    public boolean changePWD(String id, String pwd) throws SQLException {
        return userInfoDao.changePWD(id, pwd);
    }
}
