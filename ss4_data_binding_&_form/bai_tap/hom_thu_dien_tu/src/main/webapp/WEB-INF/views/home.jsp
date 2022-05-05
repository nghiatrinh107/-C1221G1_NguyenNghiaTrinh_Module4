<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Setting</h1>
<form:form method="post" modelAttribute="email">
    <div>
        Languages:
        <form:select path="languages">
            <form:option value="English"/>
            <form:option value="Vietnamese"/>
            <form:option value="Japanese"/>
            <form:option value="Chinese"/>
        </form:select>
    </div>
    <div>
        Page Size:
        <form:select path="pageSize">
            <form:option value="5"/>
            <form:option value="10"/>
            <form:option value="15"/>
            <form:option value="25"/>
            <form:option value="50"/>
            <form:option value="100"/>
        </form:select>
    </div>
    <div>
        Spams filter:
        <form:checkbox path="spamsFilter" value="true"/>
    </div>
    <div>
        Signature:
        <form:textarea path="signature" />
    </div>
    <div>
        <input type="submit" value="Update">
    </div>
</form:form>
</body>
</html>
