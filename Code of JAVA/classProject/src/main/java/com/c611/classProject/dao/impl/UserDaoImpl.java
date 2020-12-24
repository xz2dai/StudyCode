package com.c611.classProject.dao.impl;

import com.c611.classProject.Utils.C3P0Utils;
import com.c611.classProject.bean.UserInfo;
import com.c611.classProject.dao.IUserDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Akili
 * @date 2020/12/19 14:59
 * @software IntelliJ IDEA
 */
public class UserDaoImpl implements IUserDao {

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
        String sql = "select UserName userName, Password password, Money money, CreateTime creatTime, UserDescribe selfIntro, UserLevel grade, UserType grand, Age age, Mobile phoneNum, Email email, Gender sex, Birthday birthday, UserStatus state ,UserID userID from users where UserID=?";

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
    public boolean regisUserInfo(UserInfo userInfo) throws SQLException {

        //定义SQL语句
        String sql = "insert into users(UserName,Password,Email,Mobile,Age) values(?,?,?,?,?)";

        Object[] params = {userInfo.getUserName(), userInfo.getPassword(), userInfo.getEmail(), userInfo.getPhoneNum(), userInfo.getAge()};
        int count = run.update(sql,params);

        return count == 1;
    }

    @Override
    public boolean editUserInfo(UserInfo userInfo) throws SQLException {
        //定义SQL语句
        String sql = "update users set UserName=?,Gender=?,Mobile=?,Email=?,Age=?,UserDescribe=? where UserID=?";

        Object[] params = {userInfo.getUserName(), userInfo.getSex(), userInfo.getPhoneNum(), userInfo.getEmail(), userInfo.getAge(), userInfo.getSelfIntro(), userInfo.getUserID()};
        int count = run.update(sql, params);
        return count == 1;

    }

    @Override
    public UserInfo loginUserInfo(String name) throws SQLException {
        String sql="select * from users where UserName=?";
        return run.query(sql,new BeanHandler<UserInfo>(UserInfo.class),name);
    }

    @Override
    public List<UserInfo> findAll(int page, int size) throws SQLException {
        String sql = "select UserLevel grade, UserName userName, UserID userID, Gender sex,UserType grand,Mobile phoneNum,UserStatus state from users order by UserID limit ?,?";
        Object[] parms={page,size};
        return run.query(sql,new BeanListHandler<UserInfo>(UserInfo.class),parms );
    }

    @Override
    public int count() throws SQLException {
        String sql="select count(UserID) from users";
        Long count=(Long) run.query(sql,new ScalarHandler());
        return count.intValue();
    }


}
