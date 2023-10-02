<%-- 
    Document   : home.jsp
    Created on : Sep 20, 2023, 2:04:56 PM
    Author     : azmi
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <link href="home.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<form action="/MiniProject/NewServlet" method="post" align="center">
    <input type="hidden" name="action" value="register">
    
    <label for="firstname">First Name:</label>
    <input type="text" placeholder="firstname" name="firstname"><br><br>

    <label for="lastname">Last Name:</label>
    <input type="text" placeholder="lastname" name="lastname"><br><br>

    <label for="mobileno">Mobile No:</label>
    <input type="text" placeholder="mobileno" name="mobileno"><br><br>

    <label for="email">Email Add:</label>
    <input type="email" placeholder="email" name="email"><br><br>

    <label for="dob">Date of Birth:</label>
    <input type="date" placeholder="DOB" name="dob"><br><br>

    <label for="gender">Gender:</label>
    <input type="radio" id="gender" name="gender" value="1">Male
    <input type="radio" id="gender" name="gender" value="2">Female <br><br>

    <input type="submit" value="Sign Up">
</form>
</body>
</html>
