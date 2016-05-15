package music.data; 
import java.io.*; 
import java.util.*;  
import music.business.*; 
public class ProductIO 
{ 
 private static ArrayList<Product> products = null; 
 
 public static ArrayList<Product> getProducts() 
 { 
     products = new ArrayList<Product>(ProductDB.selectProducts());
     return new ArrayList<Product>(ProductDB.selectProducts());
 } 

 public static Product getProduct(String productCode) 
 {  
    return ProductDB.selectProduct(productCode);
 } 

 public static boolean exists(String productCode) 
 { 
    products = getProducts(); 
    for (Product p : products) 
    { 
        if (productCode != null && productCode.equalsIgnoreCase(p.getCode())) 
        { 
            return true; 
        } 
    } 
    return false; 
 } 

 /*private static void saveProducts(ArrayList<Product> products, String path) 
{ 
    try 
    { 
       File file = new File(path); 
       PrintWriter out = new PrintWriter(new FileWriter(file)); 
       for (Product p : products) 
       { 
           out.println(p.getCode() + "|" + p.getDescription() + "|" + p.getPrice()); 
       } 
    out.close(); 
    } 
    catch(IOException e) 
    { 
        e.printStackTrace(); 
    } 

 } */

 public static void insert(Product product) 
 { 
    products = getProducts(); 
    products.add(product);
    ProductDB.insert(product); 
    products = getProducts();
 } 

 public static void update(Product product) 
 { 
    products = getProducts(); 
    ProductDB.edit(product);
    products = getProducts();
 } 

    public static void delete(Product product) 
    { 
        products = getProducts(); 
        ProductDB.delete(product);
        products = getProducts();

    }
}