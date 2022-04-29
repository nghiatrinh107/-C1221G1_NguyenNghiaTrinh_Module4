<%--
  Created by IntelliJ IDEA.
  User: Admins
  Date: 4/29/2022
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/translate">
    <div>Tiếng Anh:
        <input type="text" name="english">
    </div>
    <div>
        <input type="submit" value="translate">
    </div>
</form>
<p> Tiếng Việt: ${result}</p>
</body>
</html>
