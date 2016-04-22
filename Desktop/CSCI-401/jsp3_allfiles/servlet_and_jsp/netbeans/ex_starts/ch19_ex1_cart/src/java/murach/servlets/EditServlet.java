/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murach.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import murach.data.ProductIO;
import murach.business.Product;
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
        
        if(sPrice.startsWith("$"))
            price = Double.parseDouble(sPrice.substring(1));
        else
            price = Double.parseDouble(sPrice);
        
        Product p = ProductIO.getProduct(code, "/WEB-INF/products.txt");
        p.setDescription(description);
        p.setPrice(price);
        
        ProductIO.update(p, "/WEB-INF/products.txt");
        
    }

}
