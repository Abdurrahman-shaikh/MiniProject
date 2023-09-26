<%-- 
    Document   : home.jsp
    Created on : Sep 20, 2023, 2:04:56 PM
    Author     : azmi
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session = "false" %>
<!--<!DOCTYPE html>
<html>
    <head>
        <title>Form</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Form</h1>
        <form action="/MiniProject/NewServlet" method="post">

            <label for="name">Name:</label>
            <input type="text" id="name" name="name"><br><br>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email"><br><br>

            <input type="submit" value="Submit">

            <input type="button" value="Cancel" onclick="window.location.href = '/MiniProject/NewServlet?cancel=true'">
        </form>
    </body>
</html>-->

<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
</head>
<body>    
    <form action="/MiniProject/NewServlet" method="post">
        <!--<label for="firstname">First Name:</label>-->
        <ul>
        <li><input type="text" placeholder="firstname" name="firstname"><br><br></li>

        <!--<label for="lastname">Last Name:</label>-->
        <li><input type="text" placeholder="lastname" name="lastname"><br><br></li>
        
        <!--<label for="mobileno">Mobile No:</label>-->
        <li><input type="text" placeholder="mobileno" name="mobileno"><br><br></li>
        
        <!--<label for="email">Email:</label>-->
        <li><input type="email" placeholder="email" name="email"><br><br></li>

        <!--<label for="dob">Date of Birth:</label>-->
        <li><input type="date" placeholder="DOB" name="dob"><br><br></li>
        
        </ul>

        <!--<label for="gender">Gender:</label>-->
        <ul>
            <li><input type="radio" id="gender" name="gender" value="1">Male</li>
            <li><input type="radio" id="gender" name="gender" value="2">Female </br></li>
        </ul>

        <input type="submit" value="Sign Up">
    </form>
</body>
</html>
