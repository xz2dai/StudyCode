package com.c611.classProject.web.servlet;

import com.c611.classProject.bean.GoodsPageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：yq
 * @description：TODO
 * @date ：2020/12/23 16:22
 */
@WebServlet("/SelectGoodsServlet")
public class SelectGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收List
        GoodsPageBean goodsPageBean = (GoodsPageBean) req.getAttribute("GoodsPageBean");
        //处理数据
        req.setAttribute("goodsList",goodsPageBean.getGoodsList());
        req.setAttribute("page",goodsPageBean.getCurrentPage());
        req.setAttribute("TotalPage",goodsPageBean.getTotalPageCount());
        req.setAttribute("size",goodsPageBean.getSize());
        //返回数据到jsp
        req.getRequestDispatcher(req.getContextPath()+"/content/makeorder.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
