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
        <h1>Login</h1>
        <form action="LogInServlet" method="POST">
            Username: <input type="text" name="txtName"> <br>
            Password: <input type="text" name="txtPass"> <br><br>
            <input type="submit" value="Submit"><br>
        </form>
        
        <a href="/ch19_ex1_cart/index.jsp">Return to Index</a>        
    </body>
</html>
