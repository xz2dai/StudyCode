package MyServlet;

import MyServlet.Beans.BookBean;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.DataSource;
import javax.naming.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/BookQueryServlet2")
public class BookQueryServlet2 extends HttpServlet {
    Connection dbconn;

    public void init() {
        try {
            Context context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/sampleDS");
            dbconn = ds.getConnection();
        } catch (NamingException ne) {
            log("Exception:" + ne);
        } catch (SQLException se) {
            log("Exception:" + se);
        }
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        String bookid = request.getParameter("bookid");
        try {
            String sql = "SELECT * FROM books WHERE bookid=?";
            PreparedStatement pstmt = dbconn.prepareStatement(sql);
            pstmt.setString(1, bookid);
            ResultSet rst = pstmt.executeQuery();
            if (rst.next()) {
                BookBean book = new BookBean();
                book.setBookid(rst.getString("bookid"));
                book.setTitle(rst.getString("title"));
                book.setAuthor(rst.getString("author"));
                book.setPrice(rst.getDouble("price"));
                book.setPublisher(rst.getString("publisher"));
                request.setAttribute("book", book);
                RequestDispatcher view =
                        request.getRequestDispatcher("/displayBook.jsp");
                view.forward(request, response);
            } else {
                response.sendRedirect("/error.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        try {
            dbconn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
