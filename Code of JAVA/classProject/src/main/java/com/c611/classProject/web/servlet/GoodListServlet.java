package com.c611.classProject.web.servlet;

import com.c611.classProject.bean.Goods;
import com.c611.classProject.service.IGoodsService;
import com.c611.classProject.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author llz
 * @version 1.0
 * @date 2020/12/23 22:26
 */
@WebServlet("/GoodList")
public class GoodListServlet extends HttpServlet {
    //通过service接口创建serviceImpl对象
    IGoodsService service=new GoodsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Goods> list =service.findGoodsList();
            req.setAttribute("list", list);
            req.getRequestDispatcher("/content/goods.jsp").forward(req,resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
