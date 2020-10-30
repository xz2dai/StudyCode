package MyServlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SendCookie extends HttpServlet{
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException,ServletException{
        Cookie userCookie = new Cookie("user", "uid1234");
        userCookie. setMaxAge(60*60*24*7);
        response.addCookie(userCookie);
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<html><title>add cookies</title>");
        out.println("<body><h2>"+
                "A cookie has been sent to browser</h2></body>");
        out.println("</html>");
    }
}