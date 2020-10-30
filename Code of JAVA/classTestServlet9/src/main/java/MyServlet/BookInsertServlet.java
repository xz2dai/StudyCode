package MyServlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import MyServlet.Beans.BookBean;
import MyServlet.DAO.BookDAO;

import javax.servlet.annotation.WebServlet;

@WebServlet("/BookInsertServlet")
public class BookInsertServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String message = null;
        BookBean book = new BookBean();
        book.setBookid(request.getParameter("bookid"));
        book.setTitle(request.getParameter("title"));
        book.setAuthor(request.getParameter("author"));
        book.setPublisher(request.getParameter("publisher"));
        book.setPrice(Float.parseFloat(request.getParameter("price")));

        BookDAO bookdao = new BookDAO();
        boolean success = bookdao.insertBook(book);
        if (success) {
            message = "成功插入一条记录！";
        } else {
            message = "插入记录错误！";
        }
        request.setAttribute("result", message);
        RequestDispatcher view =
                request.getRequestDispatcher("/bookInsert.jsp");
        view.forward(request, response);
    }
}
