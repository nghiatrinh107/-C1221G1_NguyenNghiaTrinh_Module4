<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admins
  Date: 5/5/2022
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Upload Song</h2>
<form:form  modelAttribute="song" method="post">
    <div>
        Name:
        <form:input  type="text" path="name" />
    </div>
    <div>
        singer:
        <form:input  type="text" path="singer" />
    </div>
    <div>
        Music Genre:
        <form:select path="musicGenre">
            <form:option value="pop">Pop</form:option>
            <form:option value="rap">Rap</form:option>
            <form:option value="r&b">R&B</form:option>
        </form:select>
    </div>
    <div>
        Link:
        <form:input  type="text" path="link" />
    </div>
    <div>
        <input type="submit" value="create">
    </div>
</form:form>
</body>
</html>
