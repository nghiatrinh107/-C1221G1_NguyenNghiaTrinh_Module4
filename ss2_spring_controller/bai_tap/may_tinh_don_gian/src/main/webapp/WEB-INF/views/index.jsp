<%--
  Created by IntelliJ IDEA.
  User: Admins
  Date: 5/4/2022
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form method="post" action="/calculator">
    <input type="number" name="number1" placeholder="number 1">
    <input type="number" name="number2" placeholder="number 2">
    <input type="submit" name="calculator" value="addition">
    <input type="submit" name="calculator" value="subtraction">
    <input type="submit" name="calculator" value="multiplication">
    <input type="submit" name="calculator" value="division">
</form>
<h3>Result= ${result}</h3>
</body>
</html>
