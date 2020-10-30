package MyServlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class GetCookie extends HttpServlet{
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException,ServletException{
        String cookieName = "user";
        String cookieValue = null;
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            for(int i = 0;i<cookies.length;i++){
                Cookie cookie = cookies[i];
                if(cookie.getName().equals(cookieName))
                    cookieValue = cookie.getValue();
            }
        }
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<html><title>get cookies</title>");
        out.println("<body><h2>A cookie has been got from brower</h2>");
        out.println("CookieName:"+cookieName+"<br>");
        out.println("CookieValue:"+cookieValue+"<br>");
        out.println("</body></html>");
    }
}
