package com.c611.classProject.web.servlet;

import com.c611.classProject.bean.Goods;
import com.c611.classProject.bean.Orders;
import com.c611.classProject.bean.UserInfo;
import com.c611.classProject.dao.IOrdersDao;
import com.c611.classProject.dao.impl.OrdersDaoImpl;
import com.c611.classProject.exception.UserInfoException;
import com.c611.classProject.service.IGoodsService;
import com.c611.classProject.service.IUserService;
import com.c611.classProject.service.impl.GoodsServiceImpl;
import com.c611.classProject.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Akili
 * @date 2020/12/20 13:50
 * @software IntelliJ IDEA
 */
@WebServlet("/userProfileServlet")
public class UserPofileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取表单数据
        String id=req.getParameter("userID");

        //构建服务层接口对象
        IUserService IUserService =new UserServiceImpl();

        IOrdersDao iOrdersDao=new OrdersDaoImpl();

        IGoodsService iGoodsService=new GoodsServiceImpl();

        try {
            List<Orders> list=iOrdersDao.selectByOrderUserID(Integer.parseInt(id));

            List<Goods> lists=new ArrayList<>();
            for (Orders orders : list) {

                lists.add(iGoodsService.findGoodByID(orders.getOrdergoodID()));


            }
            req.setAttribute("lists",lists);
            req.setAttribute("list",list);

            //调用通过用户id来获取用户信息的方法
            UserInfo userInfo= IUserService.getUserInfoById(id);

            //将userInfo对象数据保存到request作用域中
            req.setAttribute("userInfo",userInfo);

            //分发转向
            req.getRequestDispatcher("/content/page-profile.jsp").forward(req,resp);
        } catch (UserInfoException | SQLException e) {
            e.printStackTrace();
        }

    }
}
