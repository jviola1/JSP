<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="editID" scope="session" value="${pageContext.request.getQueryString()}"/>
        
        <c:forEach var="product" items="${products}">
            <c:if test="${product.code == editID}">
                <form action="ProductServlet" method="POST">
                Product Code: <input type="text" name="txtCode" value="${product.code}"> <br>
                Product Description: <input type="text" name="txtDescription" value="${product.description}"> <br>
                Product Price: <input type="text" name="txtPrice" value="${product.priceCurrencyFormat}"><br><br>            
                <input type="submit" value="Submit">
        </form
            </c:if>
        </c:forEach>
    </body>
</html>
