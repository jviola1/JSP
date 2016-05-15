<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    </head>
    <body>
        <c:set var="editID" scope="session" value="${pageContext.request.getQueryString()}"/>
        
        <c:forEach var="product" items="${products}">
            <c:if test="${product.code == editID}"> <!-- Looks for proper product based on code-->
                <form action="EditServlet" method="POST">
                Product Code: <input type="text" readonly name="txtCode" value="${product.code}"> <br>
                Product Description: <input type="text" name="txtDescription" value="${product.description}"> <br>
                Product Price: <input type="text" name="txtPrice" value="${product.priceCurrencyFormat}"><br>            
                <input type="submit" value="Submit"><br>
        </form
            </c:if>
        </c:forEach>
        <br>
        
        <a href="/ch19_ex1_cart/Product.jsp">Return</a>
    </body>
</html>
