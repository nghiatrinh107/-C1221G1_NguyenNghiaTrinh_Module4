<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admins
  Date: 5/4/2022
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<h1>SANDWICH CONDIMENTS</h1>
<c:if test="${mess == null}">
    <c:forEach var="x" items="${condiment}">
        <h4>${x}</h4><br>
    </c:forEach>
</c:if>
<c:if test="${mess != null}">
    <h4>${mess}</h4>
</c:if>
</body>
</html>
