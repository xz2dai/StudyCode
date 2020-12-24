package com.c611.classProject.web.servlet;

import com.c611.classProject.Utils.StringUtils;
import com.c611.classProject.bean.Goods;
import com.c611.classProject.bean.Orders;
import com.c611.classProject.bean.UserInfo;
import com.c611.classProject.exception.UserInfoException;
import com.c611.classProject.service.IOrdersService;
import com.c611.classProject.service.IUserService;
import com.c611.classProject.service.impl.OrdersServiceImpl;
import com.c611.classProject.service.impl.UserServiceImpl;

import javax.print.attribute.standard.NumberUp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author ：yq
 * @description:创建订单servlet
 * @date ：2020/12/21 0:49
 */
@WebServlet("/MakeOrderServlet")
public class MakeOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取持久层对象
        IOrdersService ordersService = new OrdersServiceImpl();
        IUserService userService = new UserServiceImpl();
        boolean done = false;
        //获取订单参数表
        UserInfo userInfo = null;
        Map<String,String[]> parammap =  req.getParameterMap();
        String userid = parammap.get("UserName")[0];
        //判断是否输入了用户名
        if(!StringUtils.isNumeric(userid)){
            //用户输入了用户名则要获取该用户的id
            try {
                //从数据库获取用户信息
                userInfo= userService.loginUserInfo(userid);
            } catch (UserInfoException e) {
                e.printStackTrace();
                ForwardBack(false,"提交订单出现错误",req,resp);
                return;
            }
            if(userInfo != null){
                    userid = String.valueOf(userInfo.getUserID());
            }else{//用户信息为空则表示用户不存在
                ForwardBack(false,"用户不存在",req,resp);
                return;
            }
        }
        String adress = parammap.get("Adress")[0];
        //如果有空参数则返回错误
        parammap.forEach((key, value) -> {
            if(value == null) {
                try {
                    ForwardBack(false,"提交订单出现错误：订单参数为空",req,resp);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            }
            //System.out.println(key + ":" + Arrays.toString(value));
        });
        //从会话获取订单表
        HttpSession session = req.getSession();
        List<Goods> selectList = (List<Goods>) session.getAttribute("selectList");
        if(selectList!=null && selectList.size()>0) {
            boolean result = true;
            for(Goods goods:selectList){

                try {
                    ordersService.addOrders(Integer.parseInt(userid),goods.getGoodID(),"地址:"+adress,0);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    ForwardBack(false,"提交订单出现错误：购物车为空",req,resp);
                    return;
                }
                System.out.println("创建订单:"+goods.getGoodName()+"id="+goods.getGoodID());
            }
            done = result;
        }


        ForwardBack(done,req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void ForwardBack(boolean done,HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        if(done){
            resp.sendRedirect(req.getContextPath()+"/content/makeorder.jsp?info=1");
            //完成订单后重置购物车
            req.getSession().setAttribute("selectList",null);
        }else{
            resp.sendRedirect(req.getContextPath()+"/content/makeorder.jsp?info=2");
        }
    }
    public void ForwardBack(boolean done,String Msg,HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
       String EncodedMsg = URLEncoder.encode(Msg, "UTF-8");
        if(done){
            req.getSession().setAttribute("selectList",null);
            String URL = String.format("/content/makeorder.jsp?info=1&infoMsg=%s",EncodedMsg);
            resp.sendRedirect(req.getContextPath()+URL);
        }else{
            String URL = String.format("/content/makeorder.jsp?info=2&infoMsg=%s",EncodedMsg);
            resp.sendRedirect(req.getContextPath()+URL);
        }

    }
}
