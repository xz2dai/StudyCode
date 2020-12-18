package com.xz2dai.OA_demo.dao.impl;

import com.xz2dai.OA_demo.Utils.C3P0Utils;
import com.xz2dai.OA_demo.bean.UserInfo;
import com.xz2dai.OA_demo.dao.IUserInfoDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**UserInfo接口实现类
 * @author yq
 * @date 2020年12月15日
 */
public class UserInfoDaoImpl implements IUserInfoDao {
    private QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

    @Override
    public UserInfo selectByAccountAndPwd(String account, String password) throws SQLException {
        // 1.定义一个sql语句
        String sql = "select id, account, password, real_name realName, gender, age, mobile, email, birthday, identity, entry_time entryTime, status, create_time createTime from user_info where account=? and password=?";
        // 2.定义一个参数数组
        Object[] params = {account, password};
        // 3.执行DQL操作，并封装UserInfo对象返回
        return queryRunner.query(sql, new BeanHandler<UserInfo>(UserInfo.class), params);
    }

    @Override
    public boolean addUserInfo(UserInfo userInfo) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<UserInfo> selectAll() throws SQLException {
        // 1.定义一个sql语句
        String sql = "select id, account, password, real_name realName, gender, age, mobile, email, birthday, identity, entry_time entryTime, status, create_time createTime from user_info";
        // 2.执行DQL操作，并封装UserInfo对象，保存到集合中，返回
        return queryRunner.query(sql, new BeanListHandler<UserInfo>(UserInfo.class));
    }

    @Override
    public boolean addUser(UserInfo userInfo) throws SQLException {
        String sql = "insert into user_info values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        // 定义参数数组
        Object[] params = {
                userInfo.getId(),
                userInfo.getAccount(),
                userInfo.getPassword(),
                userInfo.getRealName(),
                userInfo.getGender(),
                userInfo.getAge(),
                userInfo.getMobile(),
                userInfo.getEmail(),
                userInfo.getBirthday(),
                userInfo.getIdentity(),
                userInfo.getEntryTime(),
                userInfo.getStatus(),
                userInfo.getCreateTime()
        };
        int count = queryRunner.update(sql,params);
        return count==1;
    }

    @Override
    public UserInfo findUserByID(String id) throws SQLException {
        // 1.定义一个sql语句
        String sql = "select id, account, password, real_name realName, gender, age, mobile, email, birthday, identity, entry_time entryTime, status, create_time createTime from user_info where id=?";
        // 2.定义一个参数数组
        Object[] params = {id};
        // 3.执行DQL操作，并封装UserInfo对象返回
        return queryRunner.query(sql, new BeanHandler<UserInfo>(UserInfo.class), params);
    }

    @Override
    public boolean changePWD(String id, String pwd) throws SQLException {
        String sql="update user_info set password=? where id=?";
        Object[] params={pwd,id};
        int count = queryRunner.update(sql);
        return count==1;
    }
}
