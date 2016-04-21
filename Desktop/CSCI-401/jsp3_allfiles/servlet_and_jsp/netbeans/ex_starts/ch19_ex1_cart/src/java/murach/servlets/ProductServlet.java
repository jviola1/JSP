
package murach.servlets;
import murach.data.ProductIO;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import murach.business.Product;

public class ProductServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
 throws ServletException, IOException { 
        Product p = new Product(request.getParameter("txtCode"), request.getParameter("txtDescription"), Double.parseDouble(request.getParameter("txtPrice"))); 
        
        ProductIO.insert(p, "/WEB-INF/products.txt");
    }
}