package MyServlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
public class ShowSession extends HttpServlet{
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        String heading =null;
        Integer accessCount = (Integer)session.getAttribute("accessCount");
        if(accessCount==null){
            accessCount = 0;
            heading = "Welcome, Newcomer";
        }else{
            heading = "Welcome Back.";
            accessCount = accessCount.intValue() + 1;
        }
        session.setAttribute("accessCount",accessCount);
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<title>Session Tracking Example</title></head>");
        out.println("<body><center>");
        out.println("<h1>"+heading+"</h1>");
        out.println("<h2>Information about your session.</h2>");
        out.println("<table border='1'>");
        out.println("<tr bgcolor=\"ffad00\"><th>Info Type<th>Value\n");
        out.println("<tr><td>ID<td>"+session.getId()+"\n");
        out.println("<tr><td>Creation Time:<td>");
        out.println(""+new Date(session.getCreationTime())+"\n");
        out.println("<tr><td>Time of last access:<td>");
        out.println(""+new Date(session.getLastAccessedTime())+"\n");
        out.println("<tr><td>Access number:<td>"+accessCount+"\n");
        out.println("</table></center></body></html>");
    }
}
