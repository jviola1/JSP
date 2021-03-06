package music.admin;

import java.io.IOException;
import java.io.PrintWriter;
import music.data.ProductIO;
import music.business.Product;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jimmy
 */
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        ProductIO.delete(ProductIO.getProduct(request.getQueryString()));
        response.sendRedirect("Product.jsp");
        
    }

}