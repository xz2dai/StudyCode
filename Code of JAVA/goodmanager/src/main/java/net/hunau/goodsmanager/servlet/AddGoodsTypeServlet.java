package net.hunau.goodsmanager.servlet;

import net.hunau.goodsmanager.bean.GoodsType;
import net.hunau.goodsmanager.dao.TypeDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 添加商品类型servlet
 * author：yq
 * date：11-13
 */
public class AddGoodsTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TypeDAO typeDAO = new TypeDAO();
        GoodsType goodsType = new GoodsType();
        //获取参数并填入bean中
        goodsType.setId(Integer.parseInt(request.getParameter("typeID")));
        goodsType.setTypeName(request.getParameter("typeName"));
        goodsType.setTypeDec(request.getParameter("typeDec"));

        boolean done = typeDAO.AddType(goodsType);
        PrintWriter pw = response.getWriter();
        if(done){
            pw.print("<script>alert(\""+"添加成功!"+"\")</script>");
        }else{
            pw.print("<script>alert(\""+"添加失败!"+"\")</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
