<%-- 
    Document   : login
    Created on : Sep 27, 2023, 12:13:33 PM
    Author     : azmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="/MiniProject/NewServlet" method="post" align="center">
            <input type="hidden" name="action" value="login">
            <label for="email">Email:</label>
            <input type="email" placeholder="email" name="myemail"><br><br>
            
            <label for="password">Password:</label>
            <input type="password" placeholder="password" name="mypassword"><br><br>
            
            <input type="submit" name="login" value="login">
            <input type="submit" name="forget" value="forgetpassword">
        </form>
    </body>
</html>
