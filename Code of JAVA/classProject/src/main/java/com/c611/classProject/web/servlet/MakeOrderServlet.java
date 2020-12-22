package com.c611.classProject.web.servlet;

import com.c611.classProject.bean.Goods;
import com.c611.classProject.bean.Orders;
import com.c611.classProject.service.IOrdersService;
import com.c611.classProject.service.impl.IOrdersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
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
        IOrdersService ordersService = new IOrdersServiceImpl();
        boolean done = false;
        //获取订单参数
        Map<String,String[]> parammap =  req.getParameterMap();
        String userid = parammap.get("UserName")[0];
        String adress = parammap.get("Adress")[0];
        parammap.forEach((key, value) -> {
            System.out.println(key + ":" + Arrays.toString(value));
        });
        //获取订单表
        HttpSession session = req.getSession();
        List<Goods> selectList = (List<Goods>) session.getAttribute("selectList");
        if(selectList!=null) {
            for(Goods goods:selectList){
                Orders orders = new Orders();
                orders.setOrdergoodID(goods.getGoodID());
                orders.setOrderUserID(Integer.parseInt(userid));
                orders.setOrderDescribe("地址:"+adress);

                System.out.println(goods.getGoodName());
            }

            done = true;
        }


        if(done){
            resp.sendRedirect(req.getContextPath()+"/content/makeorder.jsp?info=1");
        }else{
            resp.sendRedirect(req.getContextPath()+"/content/makeorder.jsp?info=2");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
