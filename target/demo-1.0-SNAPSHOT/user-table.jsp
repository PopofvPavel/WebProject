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
</head>
<body>
<h1>Таблица пользователей</h1>
<table border="1">
    <tr>
        <th>ID_USER</th>
        <th>ID_USER_TYPE</th>
        <th>LOGIN</th>
        <th>PASSWORD</th>
        <th>IS_AUTHORIZED</th>
        <th>IS_BLOCKED</th>
    </tr>
    <%
        PrintWriter printWriter = response.getWriter();
        List<User> rows = AdminActionHandler.getUsersTableList();
        for (User row : rows) {%>
    <tr>
        <td><%=row.getIdUser()%>
        </td>
        <td><%=row.getIdUserType()%>
        </td>
        <td><%=row.getLogin()%>
        </td>
        <td><%=row.getPassword()%>
        </td>
        <td><%=row.isAuthorized()%>
        </td>
        <td><%=row.isBlocked()%>
        </td>
        <%} %>

    </tr>

</table>
</body>
</html>
