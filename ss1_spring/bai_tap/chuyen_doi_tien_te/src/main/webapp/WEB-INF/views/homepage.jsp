<%--
  Created by IntelliJ IDEA.
  User: Admins
  Date: 4/29/2022
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/convert" method="post">
    <div>
        USD:
        <input type="number" name="usd">
    </div>
    <div>
        <input type="submit" name="convert" value="convert">
    </div>
    <div>
        <p>VND: ${result} VND</p>
    </div>
</form>
</body>
</html>
