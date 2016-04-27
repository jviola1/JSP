<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    </head>
    <body>
        <c:set var="deleteID" scope="session" value="${pageContext.request.getQueryString()}"/>
        
        <c:forEach var="product" items="${products}">
            <c:if test="${product.code == deleteID}">
                <form action="DeleteServlet" method="POST">
                Product Code: ${product.code} <br>
                Product Description: ${product.description}<br>
                Product Price: ${product.priceCurrencyFormat}<br>            
                <input type="submit" value="Delete"><br>
        </form
            </c:if>
        </c:forEach>
        <br>
        <a href="/ch19_ex1_cart/Product.jsp">Return</a>
    </body>
</html>
