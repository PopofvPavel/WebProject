<%@ page import="java.io.PrintWriter" %>
<%@ page import="ru.rsreu.datalayer.data.User" %>
<%@ page import="ru.rsreu.datalayer.handlers.AdminActionHandler" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.rsreu.datalayer.data.Worker" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 29.11.2022
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Workers table</title>
    <style>
        <jsp:include page="css/style.css"/>
    </style>
</head>
<body>
<div class="table-container">
    <h1>Таблица работников</h1>
    <table class="data-table">
        <tr class="data-table-row">
            <th class="data-table-col">ID_WORKER</th>
            <th>POST</th>
            <th class="data-table-col">FIO</th>
        </tr>
        <%
            PrintWriter printWriter = response.getWriter();
            List<Worker> rows = AdminActionHandler.getWorkerTableList();
            for (Worker row : rows) {%>
        <tr class="data-table-row">
            <td class="data-table-col"><%=row.getIdWorker()%>
            </td>
            <td class="data-table-col"><%=row.getPost()%>
            </td>
            <td class="data-table-col"><%=row.getFIO()%>
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
