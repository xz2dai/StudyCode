package MyServlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import MyServlet.Beans.BookBean;
import MyServlet.DAO.BookDAO;

import javax.servlet.annotation.WebServlet;

@WebServlet("/BookQueryServlet3")
public class BookQueryServlet3 extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        String bookid = request.getParameter("bookid");
        BookDAO bookdao = new BookDAO();
        BookBean book = bookdao.searchBook(bookid);
        if (book != null) {
            request.getSession().setAttribute("book", book);
            response.sendRedirect("/helloweb/displayBook.jsp");
        } else {
            response.sendRedirect("/helloweb/errorPage.jsp");
        }
    }
}
