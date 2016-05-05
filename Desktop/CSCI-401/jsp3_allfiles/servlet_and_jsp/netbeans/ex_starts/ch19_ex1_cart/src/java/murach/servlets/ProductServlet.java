
package murach.servlets;
import murach.data.ProductIO;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import murach.business.Product;
//import murach.*;
//import murach.data.ProductDB;

public class ProductServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
 throws ServletException, IOException { 
        
        String code = request.getParameter("txtCode");
        String description = request.getParameter("txtDescription");
        double price = Double.parseDouble(request.getParameter("txtPrice"));
        
        Product p = new Product(code, description, price);
        ProductIO.insert(p);
        
        response.sendRedirect("Product.jsp");
    }
}