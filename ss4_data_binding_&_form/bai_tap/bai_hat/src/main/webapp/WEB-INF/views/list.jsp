<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<table border="1px">
    <tr>
        <td>STT</td>
        <td>Tên bài hát</td>
        <td>Nghệ sĩ</td>
        <td>Thể loại nhạc</td>
        <td>Link</td>
    </tr>
    <c:forEach items="${song}" var="x" varStatus="stt">
    <tr>
        <td>${stt.count}</td>
        <td>${x.singer}</td>
        <td>${x.name}</td>
        <td>${x.musicGenre}</td>
        <td>${x.link}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
