package net.hunau.goodsmanager.servlet;

import net.hunau.goodsmanager.bean.Goods;
import net.hunau.goodsmanager.biz.GoodsBiz;
import net.hunau.goodsmanager.dao.GoodsDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsDAO goodsDAO = new GoodsDAO();
        Goods goods = new Goods();
        goods.setId(Integer.parseInt(request.getParameter("productId")));
        goods.setGoodname(request.getParameter("productName"));
        goods.setGoodcount(Integer.parseInt(request.getParameter("productCount")));
        goods.setGoodprice(Double.parseDouble(request.getParameter("productPrice")));
        goods.setGoodtype(Integer.parseInt(request.getParameter("productType")));
        goods.setGoodDep(request.getParameter("productDep"));

        boolean done = goodsDAO.updateGoods(goods);
        PrintWriter pw = response.getWriter();
        if(done){
            pw.print("<script>alert(\""+"添加成功!"+"\")</script>");
        }else{
            pw.print("<script>alert(\""+"添加失败!"+"\")</script>");
        }
        response.sendRedirect(request.getContextPath()+"/servlet/ScanGoodServlet?productID="+goods.getId());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
