package MyServlets;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.nio.charset.StandardCharsets;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws java.io.IOException,ServletException {
        String name = request.getParameter("custName");
        name = new String(name.getBytes(StandardCharsets.ISO_8859_1),"gb2312");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        CustomerBean customer = new CustomerBean(name,email,phone);
        HttpSession session = request.getSession();
        synchronized(session) {
            session.setAttribute("customer", customer);
        }
        RequestDispatcher view =
                request.getRequestDispatcher("/displayCustomer.jsp");
        view.forward(request,response);
    }
}
