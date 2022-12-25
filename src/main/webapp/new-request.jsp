<%@ page import="ru.rsreu.datalayer.handlers.SystemHandler" %>
<%@ page import="ru.rsreu.datalayer.DAO.DAOFactory" %>
<%@ page import="ru.rsreu.datalayer.DAO.DBType" %>
<%@ page import="ru.rsreu.datalayer.DAO.RequestsDAO" %>
<%@ page import="ru.rsreu.datalayer.data.Request" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 05.12.2022
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Запрос</title>
    <style>
        <jsp:include page="css/style.css"/>
    </style>
</head>
<body>
<div class="block-bright">
    <%
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        RequestsDAO requestsDAO = factory.getRequestsDAO();
        Request lastCapRequest = requestsDAO.getLastRequestById(3);
        boolean isRequestTypeCorrect = (boolean) request.getSession().getAttribute("isRequestTypeCorrect");
        if(isRequestTypeCorrect){
    %>
<%--Vrode vstavil, id =--%>
    <%= "Request is accepted, id = "+lastCapRequest.getIdRequest()%>

    <%} else {%>
    <%= "Request is denied, you can't send this type now "%>
    <%}%>
</div>
</body>
</html>
