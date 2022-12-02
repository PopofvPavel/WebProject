<%@ page import="java.io.PrintWriter" %>
<%@ page import="ru.rsreu.datalayer.data.User" %>
<%@ page import="ru.rsreu.datalayer.handlers.AdminActionHandler" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 29.11.2022
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User table</title>
    <style><jsp:include page="css/style.css"/></style>
</head>
<body>
<div class="table-container">
    <h1>Таблица пользователей</h1>
    <table class="data-table">
        <tr class="data-table-row">
            <th class="data-table-col">ID_USER</th>
            <th>ID_USER_TYPE</th>
            <th class="data-table-col">LOGIN</th>
            <th class="data-table-col">PASSWORD</th>
            <th class="data-table-col">IS_AUTHORIZED</th>
            <th class="data-table-col"IS_BLOCKED</th>
        </tr>
        <%
            PrintWriter printWriter = response.getWriter();
            List<User> rows = AdminActionHandler.getUsersTableList();
            for (User row : rows) {%>
        <tr class="data-table-row">
            <td class="data-table-col"><%=row.getIdUser()%>
            </td>
            <td class="data-table-col"><%=row.getIdUserType()%>
            </td>
            <td class="data-table-col"><%=row.getLogin()%>
            </td>
            <td class="data-table-col"><%=row.getPassword()%>
            </td>
            <td class="data-table-col"><%=row.isAuthorized()%>
            </td>
            <td class="data-table-col"><%=row.isBlocked()%>
            </td>
            <%} %>

        </tr>

    </table>
</div>

</body>
</html>
