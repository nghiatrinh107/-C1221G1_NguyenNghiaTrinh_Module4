<%--
  Created by IntelliJ IDEA.
  User: Admins
  Date: 5/4/2022
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>SANDWICH CONDIMENTS</h1>
<form action="/condiments" method="post">
<span><input type="checkbox" name="condiments" value="lettuce"> Lettuce</span>
<span><input type="checkbox" name="condiments" value="tomato"> Tomato</span>
<span><input type="checkbox" name="condiments" value="mustard"> Mustard</span>
<span><input type="checkbox" name="condiments" value="sprouts"> Sprouts</span><br>
    <span><input type="submit" value="save"></span>

</form>
</body>
</html>
