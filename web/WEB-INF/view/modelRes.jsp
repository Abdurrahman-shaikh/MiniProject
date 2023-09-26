<%-- 
    Document   : modelRes
    Created on : Sep 23, 2023, 8:48:14 AM
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
        <h1>Hello World!</h1>
        <p> The name is: <%= request.getAttribute("name") %> </p>
    </body>
</html>
