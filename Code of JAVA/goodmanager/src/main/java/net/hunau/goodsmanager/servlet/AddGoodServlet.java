package net.hunau.goodsmanager.servlet;

import net.hunau.goodsmanager.bean.Goods;
import net.hunau.goodsmanager.biz.GoodsBiz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddGoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsBiz goodsBiz = new GoodsBiz();
        Goods goods = new Goods();
        goods.setGoodname(request.getParameter("productName"));
        goods.setGoodcount(Integer.parseInt(request.getParameter("productNumber")));
        goods.setGoodprice(Double.parseDouble(request.getParameter("productPrice")));
        goods.setGoodtype(Integer.parseInt(request.getParameter("productType")));
        goods.setGoodDep(request.getParameter("description"));


        boolean done =  goodsBiz.addGoods(goods);
        PrintWriter pw = response.getWriter();
        if(done){
            pw.print("<script>alert(\""+"添加成功!"+"\")</script>");
        }else{
            pw.print("<script>alert(\""+"添加失败!"+"\")</script>");
        }
        RequestDispatcher rd = request.getRequestDispatcher("/content/goodsManager/searchGoods.jsp?productName="+goods.getGoodname());
        rd.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
