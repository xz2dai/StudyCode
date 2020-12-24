package com.c611.classProject.web.servlet;

import com.c611.classProject.bean.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：yq
 * @description：TODO
 * @date ：2020/12/23 16:21
 */
@WebServlet("/ChangeSelectServlet")
public class ChangeSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1获取session中的SelectList
        List<Goods> selectList = null;
        Object m_selectList = req.getSession().getAttribute("selectList");
        if(m_selectList == null) selectList = new ArrayList<>();
        selectList = (List<Goods>) m_selectList;

        List<Goods> goodsList = null;
        //2获取请求中的index、delete参数
        //添加商品
        String index = req.getParameter("index");
        if (index != null && !index.equals("")) {
            selectList.add(goodsList.get(Integer.parseInt(index) - 1));
            req.getSession().setAttribute("selectList", selectList);
        }
        //删除商品
        String delete = req.getParameter("delete");
        if (delete != null && !delete.equals("")) {
            selectList.remove(Integer.parseInt(delete) - 1);
            req.getSession().setAttribute("selectList", selectList);
        }
        //3修改List
        //4返回List到SelectGoodsServlet
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
