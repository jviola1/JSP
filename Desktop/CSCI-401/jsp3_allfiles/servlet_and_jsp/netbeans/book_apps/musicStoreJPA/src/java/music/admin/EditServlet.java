
package music.admin;

import java.io.IOException;
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
public class EditServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("txtCode");
        String description = request.getParameter("txtDescription");
        String sPrice = request.getParameter("txtPrice");
        Double price;
        
        //Parses inputted price and cuts off the "$" if it starts with one
        try
        {
        if(sPrice.startsWith("$"))
            price = Double.parseDouble(sPrice.substring(1));
        else
            price = Double.parseDouble(sPrice);
        } catch(NumberFormatException e)
        {
            throw e;
        }
        
        Product p = ProductIO.getProduct(code);
        p.setDescription(description);
        p.setPrice(price);
        
        ProductIO.update(p);
        
        response.sendRedirect("Product.jsp");
        
    }

}
