package MyServlet.DAO;

import java.security.PublicKey;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import MyServlet.Beans.BookBean;

public class BookDAO {
    private static InitialContext context= null;
    private DataSource dataSource = null;

    public BookDAO(){
        try{
            if(context == null){
                context = new InitialContext();
            }
            dataSource = (DataSource)context.lookup("java:comp/env/jdbc/sampleDS");
        }catch (NamingException e){
            e.printStackTrace();
        }
    }
    public BookBean searchBook(String bookid){
        Connection dbconn = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        BookBean book = new BookBean();
        try{
            dbconn = dataSource.getConnection();
            pstmt = dbconn.prepareStatement("SELECT * FROM books WHERE bookid=?");
            pstmt.setString(1,bookid);
            rst = pstmt.executeQuery();
            if(rst.next()){
                book.setBookid(rst.getString("bookid"));
                book.setTitle(rst.getString("title"));
                book.setAuthor(rst.getString("author"));
                book.setPublisher(rst.getString("publisher"));
                book.setPrice(rst.getDouble("price"));
                return book;
            }else{
                return null;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if (dbconn != null) {
                    dbconn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean insertBook(BookBean book){
        Connection dbconn = null;
        PreparedStatement pstmt = null;
        try{
            dbconn = dataSource.getConnection();
            pstmt = dbconn.prepareStatement("INSERT INTO books VALUES(?,?,?,?,?)");
            pstmt.setString(1,book.getBookid());
            pstmt.setString(2,book.getTitle());
            pstmt.setString(3,book.getAuthor());
            pstmt.setString(4,book.getPublisher());
            pstmt.setDouble(5,book.getPrice());

            pstmt.executeUpdate();
            pstmt.close();

            return true;
        }catch (SQLException e){
            return false;
        }finally {
            try {
                    if (dbconn != null) {
                        dbconn.close();
                    }
            }catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


}
