<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26.12.2022
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ban result</title>
    <style>
        <jsp:include page="css/style.css"/>
    </style>
</head>
<body>
<% if ((boolean) request.getAttribute("isBanned")) {

%>
<%="User is banned"%>
<%} else {%>
<%="User is razbanned " %>

<%}%>
<form action="moder-page.jsp" method="get">
    <input type="submit" class="button" value="Back">
</form>
</body>
</html>
