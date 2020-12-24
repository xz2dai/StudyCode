package com.c611.classProject.web.servlet;

import com.c611.classProject.bean.GoodsPageBean;
import com.c611.classProject.service.IGoodsService;
import com.c611.classProject.service.impl.GoodsServiceImpl;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author ：yq
 * @description：TODO
 * @date ：2020/12/23 16:18
 */
@WebServlet("/SearchGoodsListServlet")
public class SearchGoodsListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、接收page,size参数
        //当前商品表页数
        String goodsListPage = req.getParameter("page");
        int GoodsListPage;
        if (!StringUtils.isNullOrEmpty(goodsListPage)) {
            GoodsListPage = Integer.parseInt(goodsListPage);
        } else {
            GoodsListPage = 1;      //没有参数就设置为1
        }
        int size = 10;
        //2、查询数据库
        IGoodsService goodsService = new GoodsServiceImpl();
        GoodsPageBean goodsPageBean = null;
        try {
            goodsPageBean = goodsService.getGoodsPageBean(GoodsListPage,size);
            req.setAttribute("GoodsPageBean",goodsPageBean);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //3、返回Goods
        req.getRequestDispatcher(req.getContextPath()+"/ChangeSelectServlet").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
