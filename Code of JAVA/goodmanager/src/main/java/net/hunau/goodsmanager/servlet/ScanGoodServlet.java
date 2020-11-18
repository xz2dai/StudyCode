package net.hunau.goodsmanager.servlet;

import net.hunau.goodsmanager.bean.Goods;
import net.hunau.goodsmanager.biz.GoodsBiz;
import net.hunau.goodsmanager.biz.UserBiz;
import net.hunau.goodsmanager.dao.GoodsDAO;
import net.hunau.goodsmanager.dao.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScanGoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodsId = request.getParameter("productID");
        String goodsName = request.getParameter("productName");
        List<Goods> goodsList = new ArrayList<>();
        GoodsDAO goodsDAO = new GoodsDAO();
        GoodsBiz goodsBiz = new GoodsBiz();
        Goods goods = new Goods();
        if((goodsId != null && !goodsId.equals(""))&&(goodsName != null && !goodsName.equals(""))){
            goods.setGoodname(goodsName);
            goods.setId(Integer.parseInt(goodsId));
            goodsList = goodsBiz.findGoods(goods);
        }else{
            if(goodsId != null && !goodsId.equals("")){
                goods = goodsDAO.getGoods(Integer.parseInt(goodsId));
                if(goods!=null) goodsList.add(goods);
            }else if(goodsName != null && !goodsName.equals("")){
                goodsList.addAll(goodsDAO.getGoods(goodsName));
            }
        }
        //去除重复项
        goodsList = goodsList.stream().distinct().collect(Collectors.toList());
        request.setAttribute("goodsList",goodsList);

        RequestDispatcher rd = request.getRequestDispatcher("/content/goodsManager/searchGoods.jsp");
        rd.forward(request,response);
    }
}
