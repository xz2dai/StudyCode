package com.xz2dai.OA_demo.service;

import com.xz2dai.OA_demo.bean.UserInfo;
import com.xz2dai.OA_demo.exception.UserInfoException;
import com.xz2dai.OA_demo.service.impl.UserInfoServiceImpl;

import java.sql.SQLException;
import java.util.List;

/**UserInfoService接口
 *
 * @author yq
 * @date 2020年12月15日
 */
public interface IUserInfoService {
    /**
     * 登录业务
     *
     * @param account
     * @param password
     * @return
     * @throws UserInfoException
     */
    UserInfo login(String account, String password);
    /**
     * 得到所有用户信息的业务
     *
     * @return
     * @throws UserInfoException
     */
    List<UserInfo> getUserInfoList() throws UserInfoException;
    boolean addUser(UserInfo userInfo) throws SQLException;

    UserInfo findUserByID(String id) throws UserInfoException,SQLException;

    boolean changePWD(String id,String pwd) throws SQLException;
}
