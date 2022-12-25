<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 20.12.2022
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>You are banned</title>
    <style>
        <jsp:include page="css/style.css"/>
    </style>
</head>
<body>
<div class="ban-image">
    <IMG  src="css/banned.png"></IMG>
</div>
<div>
    <form action="login.jsp">
        <input type="submit" class="button" value="Back to login">

    </form>
</div>
</body>
</html>
