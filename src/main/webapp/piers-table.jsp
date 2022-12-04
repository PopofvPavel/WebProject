<%@ page import="java.io.PrintWriter" %>
<%@ page import="ru.rsreu.datalayer.data.User" %>
<%@ page import="ru.rsreu.datalayer.handlers.AdminActionHandler" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.rsreu.datalayer.data.Worker" %>
<%@ page import="ru.rsreu.datalayer.data.Pier" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 03.12.2022
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Piers table</title>
    <style>
        <jsp:include page="css/style.css"/>
    </style>
</head>
<body>
<div class="table-container">
    <h1>Таблица работников</h1>
    <table class="data-table">
        <tr class="data-table-row">
            <th class="data-table-col">ID_PIER</th>
            <th>STATUS</th>
            <th class="data-table-col">ID_SHIP</th>
        </tr>
        <%
            PrintWriter printWriter = response.getWriter();
            List<Pier> rows = AdminActionHandler.getPierTableList();
            for (Pier row : rows) {%>
        <tr class="data-table-row">
            <td class="data-table-col"><%=row.getIdPier()%>
            </td>
            <td class="data-table-col"><%=row.getStatus()%>
            </td>
            <td class="data-table-col"><%=row.getIdShip()%>
            </td>
            <%} %>

        </tr>
    </table>

    <form action="admin-page.jsp" method="get">
        <input type="submit" class="button" value="Назад">
    </form>

</div>
</body>
</html>
