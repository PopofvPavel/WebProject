<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26.12.2022
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Moving ship status</title>
        <style>
            <jsp:include page="css/style.css"/>
        </style>
</head>
<body>
<% if ((boolean) request.getSession().getAttribute("isShipMoved")) {

%>
<%="Your ship was moved to/from pier " + (int) request.getSession().getAttribute("idPier")%>
<%} else {%>
<%="Your ship wasn't moved to pier (no empty piers or ship is already moved) " %>

<%}%>
<form action="pilot-page.jsp" method="get">
    <input type="submit" class="button" value="Back">
</form>
</body>
</html>
