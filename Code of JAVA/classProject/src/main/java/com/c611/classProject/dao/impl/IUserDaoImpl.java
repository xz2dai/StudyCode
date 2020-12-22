package com.c611.classProject.dao.impl;

import com.c611.classProject.Utils.C3P0Utils;
import com.c611.classProject.bean.UserInfo;
import com.c611.classProject.dao.IUserDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Akili
 * @date 2020/12/19 14:59
 * @software IntelliJ IDEA
 */
public class IUserDaoImpl implements IUserDao {

    // DBUtils工具类的对象
    private QueryRunner run = new QueryRunner(C3P0Utils.getDataSource());


    @Override
    public List<UserInfo> findAll() throws SQLException {

        //定义SQL语句
        String sql = "select UserLevel grade, UserName userName, UserID userID, Gender sex,UserType grand,Mobile phoneNum,UserStatus state from users";

        //执行DQL操作，并封装UserInfo对象，并保存到集合中返回
        return run.query(sql, new BeanListHandler<UserInfo>(UserInfo.class));
    }

    @Override
    public UserInfo getUserInfoById(String id) throws SQLException {

        //定义SQL语句
        String sql = "select UserLevel grade, UserName userName, UserID userID, Gender sex,UserType grand,Mobile phoneNum,UserStatus state,Money money,CreateTime creatTime,Email email,Age age,Birthday birthday from users where UserID=?";

        // 执行DQL操作，并封装UserInfo对象返回
        return run.query(sql, new BeanHandler<UserInfo>(UserInfo.class), id);
    }

    @Override
    public boolean delUserInfoById(String id) throws SQLException {

        //定义SQL语句
        String sql = "delete from users where UserID=?";
        int count = run.update(sql, id);
        return count == 1;
    }

    @Override
    public boolean editUserInfo(UserInfo userInfo) throws SQLException {
        //定义SQL语句
        String sql="update users set UserName=?,Gender=?,Mobile=?,Email=?,Age=?,UserDescribe=? where UserID=?";

        Object[] params={userInfo.getUserName(),userInfo.getSex(),userInfo.getPhoneNum(),userInfo.getEmail(),userInfo.getAge(),userInfo.getSelfIntro(),userInfo.getUserID()};
        int count=run.update(sql,params);
        return count==1;

    }
}
