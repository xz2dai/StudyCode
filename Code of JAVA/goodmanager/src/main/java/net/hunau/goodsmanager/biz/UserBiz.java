package net.hunau.goodsmanager.biz;

import net.hunau.goodsmanager.bean.User;
import net.hunau.goodsmanager.dao.UserDAO;
import net.hunau.goodsmanager.utils.SaveInfoUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 实现用户的登录验证业务逻辑
 */
public class UserBiz {
    /**
     * 登陆验证方法
     *
     * @param username 用户名
     * @param password 密码
     * @return 登陆是否成功的布尔值
     */
    public User login(String username, String password) {
        boolean result = false;
        UserDAO userDAO = new UserDAO();
        User userbean = null;
        userbean = userDAO.getUser(username);
        if (password.equals(userbean.getPassword()))
            return userbean;
        else
            return null;
    }

    /**
     * 修改validateFlag字段的值
     * @param userName 用户名
     * @param flag 修改validateflag参数的目标值
     * @return 修改是否成功
     */
    public boolean iscancelUser(String userName,int flag){
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUser(userName);
        if(user!=null){
            user.setValidateFlag(flag);
            return userDAO.upUserData(user);
        }
        return false;
    }
}
