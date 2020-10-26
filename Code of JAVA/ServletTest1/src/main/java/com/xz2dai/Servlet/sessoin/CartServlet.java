package com.xz2dai.Servlet.sessoin;

import com.xz2dai.Servlet.Bean.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        List<Book> cart = null;
        boolean purFlag = true;
        HttpSession session = request.getSession(false);
        if(session == null){
            purFlag = false;
        }else{
            cart = (List)session.getAttribute("cart");
            if(cart == null){
                purFlag = true;
            }
        }
        if(!purFlag){
            out.write("您尚未购买任何商品！<br/>");
        }else{
            out.write("您购买的商品有:<br/>");
            double price = 0;
            for(Book book:cart){
                out.write(book.getName()+"<br/>");
            }
        }
    }
}
