package net.hunau.goodsmanager.servlet;

import net.hunau.goodsmanager.dao.GoodsDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 修改与添加商品servlet
 * author：yq
 * date：11-5
 */
public class EditDelGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsDAO goodsDAO = new GoodsDAO();
        PrintWriter pw = response.getWriter();
        int goodid = Integer.parseInt(request.getParameter("goodsid"));//获取参数
        String op = request.getParameter("op");
        //判断id是否为空，避免NOP错误
        if(!"".equals(Integer.valueOf(goodid)) && !"0".equals(Integer.valueOf(goodid))){
            if(op!= null && op.equals("del")){
                boolean done =  goodsDAO.delGoods(goodid); //执行并获取结果
                if(done){   //根据结果返回提示
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
        }else{  //若id为空则返回错误提示
            pw.print("<script>alert(\""+"获取id失败!"+"\")</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
