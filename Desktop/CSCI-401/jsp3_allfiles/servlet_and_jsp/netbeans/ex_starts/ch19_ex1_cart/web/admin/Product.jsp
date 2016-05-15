<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
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
        <h1>Products</h1>
        
        <table id="tb1">
            <tr>
                <th>Code</th>
                <th>Description</th>
                <th class="right">Price</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach var="product" items="${products}">
            <tr>
                <td><c:out value='${product.code}' /></td>
                <td><c:out value='${product.description}' /></td>
                <td class="right">${product.priceCurrencyFormat}</td>
                <td> <a href="/ch19_ex1_cart/edit.jsp?${product.code}"> Edit </td> <!-- Sends user to edit page with product code appended to the end-->
                <td> <a href="/ch19_ex1_cart/delete.jsp?${product.code}"> Delete </td> <!-- Sends user to delete page with product code appended to the end-->
            </tr>
        </c:forEach>
        </table>
        <br>
        <button onclick="window.location.href='AddProduct.jsp'">Add Product</button> <br> <br>
        <a href="/ch19_ex1_cart/index.jsp">Return to Index</a>        
    </body>
</html>
