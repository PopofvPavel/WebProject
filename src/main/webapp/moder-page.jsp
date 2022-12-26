<%@ page import="java.io.PrintWriter" %>
<%@ page import="ru.rsreu.datalayer.data.User" %>
<%@ page import="ru.rsreu.datalayer.handlers.AdminActionHandler" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 07.12.2022
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Moder</title>
    <style>
        <jsp:include page="css/style.css"/>
    </style>
</head>
<body>
<div id="header">

    <div>
        <h1><a href="index.jsp">Главная страница</a></h1>
    </div>
    <div>id =  ${idUser}</div>
</div>

<div class="table-container">
    <h1>Таблица пользователей</h1>
    <table class="data-table">
        <tr class="data-table-row">
            <th class="data-table-col">ID_USER</th>
            <th>ID_USER_TYPE</th>
            <th class="data-table-col">LOGIN</th>
            <th class="data-table-col">PASSWORD</th>
            <th class="data-table-col">IS_AUTHORIZED</th>
            <th class="data-table-col">IS_BLOCKED</th>
            <th class="data-table-col">ACTION</th>
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
            <td class="data-table-col">
                <form action="HelloServlet" method="post">
                    <%-- <jsp: param name="idReq" value="1"/>--%>
                        <p><input name="idUserLine" type="radio" class="id-radio-button" value="<%=row.getIdUser()%>" checked>
                    <input type="submit" class="button" name="command" value="Ban">
                    <input type="submit" class="button" name="command" value="Razban">

                </form>

            </td>
            <%} %>

        </tr>
    </table>

    <form action="index.jsp" method="get">
        <input type="submit" class="button" value="Назад">
    </form>


</div>
</body>
</html>
