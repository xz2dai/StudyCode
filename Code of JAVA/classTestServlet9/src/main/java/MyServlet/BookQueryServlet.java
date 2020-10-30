package MyServlet;

import MyServlet.Beans.BookBean;
import MyServlet.DAO.DbcpDAO;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/BookQueryServlet")
public class BookQueryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Connection dbconn;
    BookBean book = new BookBean();

    @Override
    public void init(ServletConfig config) {
        System.out.println("BookQueryServlet初始化中");
        DbcpDAO dbcpDAO = new DbcpDAO();
        //创建数据库连接对象
        dbconn = dbcpDAO.getConnect();
        if (dbconn != null) System.out.println("数据库连接成功");
        else System.out.println("数据库连接失败");
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

//        if(dbconn == null){
//            response.sendRedirect("/error.jsp");
//            return;
//        }
        String bookid = request.getParameter("bookid");
        try {
            String sql = "SELECT * FROM books WHERE bookid=" + bookid;
            PreparedStatement pstmt = dbconn.prepareStatement(sql);
//            pstmt.setString(1,bookid);
            ResultSet rst = pstmt.executeQuery();
            if (rst.next()) {
                book.setBookid(rst.getString("bookid"));
                book.setTitle(rst.getString("title"));
                book.setAuthor(rst.getString("author"));
                book.setPrice(rst.getFloat("price"));
                book.setPublisher(rst.getString("publisher"));
                request.getSession().setAttribute("book", book);
                RequestDispatcher view =
                        request.getRequestDispatcher("/displayBook.jsp");
                view.forward(request, response);
            } else {
                RequestDispatcher view =
                        request.getRequestDispatcher("/error.jsp");
                view.forward(request, response);
            }
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        try {
            dbconn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("BookQueryServlet销毁完毕");
    }


}
