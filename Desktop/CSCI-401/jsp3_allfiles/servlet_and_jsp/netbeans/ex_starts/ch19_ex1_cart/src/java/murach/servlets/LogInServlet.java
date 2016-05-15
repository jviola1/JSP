package murach.servlets;

import java.io.IOException;
import murach.data.UserDB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Jimmy
 */
public class LogInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        
        if(UserDB.isAllowed(request.getParameter("txtName"), request.getParameter("txtPass")))
            response.sendRedirect("Product.jsp");
        else
            response.sendRedirect("login.jsp");
        
    }

}