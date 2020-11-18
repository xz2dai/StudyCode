package net.hunau.goodsmanager.servlet;

import net.hunau.goodsmanager.dao.GoodsDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EditDelGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsDAO goodsDAO = new GoodsDAO();
        PrintWriter pw = response.getWriter();
        int goodid = Integer.parseInt(request.getParameter("goodsid"));
        String op = request.getParameter("op");
        if(!"".equals(Integer.valueOf(goodid)) && !"0".equals(Integer.valueOf(goodid))){
            if(op!= null && op.equals("del")){
                boolean done =  goodsDAO.delGoods(goodid);
                if(done){
                    pw.print("<script>alert(\""+"更新成功!"+"\")</script>");
                }else{
                    pw.print("<script>alert(\""+"更新失败!"+"\")</script>");
                }
                RequestDispatcher rd = request.getRequestDispatcher("/content/goodsManager/searchGoods.jsp");
                rd.forward(request,response);
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("/content/goodsManager/updateGoods.jsp?goodsid="+goodid);
                rd.forward(request,response);
            }
        }else{
            pw.print("<script>alert(\""+"获取id失败!"+"\")</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
