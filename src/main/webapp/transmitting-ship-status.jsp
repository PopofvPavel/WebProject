<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26.12.2022
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <jsp:include page="css/style.css"/>
    </style>
</head>
<body>
<% if ((boolean) request.getSession().getAttribute("isShipTransmitted")) {

%>
<%="Your ship was successfully  transmitted " %>
<%} else {%>
<%="You'r ship cant be transmitted to move now(no empty piers or action is not available) " %>

<%}%>
<form action="captain-page.jsp" method="get">
    <input type="submit" class="button" value="Back">
</form>
</body>
</html>
