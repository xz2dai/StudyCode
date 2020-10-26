package com.xz2dai.Servlet.sessoin;

import com.xz2dai.Servlet.Bean.Book;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PurchaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if(id == null){
            String url = "/t1/ListBookServlet";
            response.sendRedirect(url);
            return ;
        }
        Book book = BookDB.getBook(id);
        HttpSession session = request.getSession();
        List<Book> cart = (List)session.getAttribute("cart");
        if(cart == null){
            cart = new ArrayList<Book>();
            session.setAttribute("cart",cart);
        }
        cart.add(book);
        Cookie cookie = new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(60*30);
        cookie.setPath("/t1");
        response.addCookie(cookie);
        String url = "/t1/CartServlet";
        response.sendRedirect(url);
    }
}
