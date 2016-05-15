<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Murach's Java Servlets and JSP</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <h1>Product</h1>
        <br>
        <i>You must enter a description for the product.</i>
        <br>
        <form action="ProductServlet" method="POST">
            Product Code: <input type="text" name="txtCode"> <br>
            Product Description: <input type="text" name="txtDescription"> <br>
            Product Price: <input type="text" name="txtPrice"><br><br>            
            <input type="submit" value="Submit">
        </form>
    </body> 
</html>