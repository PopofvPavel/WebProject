<%@ page import="java.io.PrintWriter" %>
<%@ page import="ru.rsreu.datalayer.data.User" %>
<%@ page import="ru.rsreu.datalayer.handlers.AdminActionHandler" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.rsreu.datalayer.handlers.DispatcherActionHandler" %>
<%@ page import="ru.rsreu.datalayer.data.RequestStatus" %>
<%@ page import="ru.rsreu.datalayer.data.Request" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 07.12.2022
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pilot</title>
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
    <h1>Таблица запросов</h1>
    <table class="data-table">
        <tr class="data-table-row">
            <th class="data-table-col">ID_REQUEST</th>
            <th>REQUEST_TYPE</th>
            <th class="data-table-col">STATUS</th>
            <th class="data-table-col">ID_CAPTAIN</th>
            <th class="data-table-col">Update</th>
        </tr>
        <%
            PrintWriter printWriter = response.getWriter();
            List<Request> rows = DispatcherActionHandler.getAllRequestsList();
            for (Request row : rows) { if (row.getRequestStatus().equals(RequestStatus.IN_WAITING)){
                    %>
        <tr class="data-table-row">
            <td class="data-table-col" ><%=row.getIdRequest()%>
            </td>
            <td class="data-table-col"><%=row.getRequestType()%>
            </td>
            <td class="data-table-col"><%=row.getRequestStatus()%>
            </td>
            <td class="data-table-col"><%=row.getIdCaptain()%>
            </td>
            <td class="data-table-col">
                <form action="HelloServlet" method="post">
                    <%-- <jsp: param name="idReq" value="1"/>--%>
                    <input type="submit" class="button" name="command" value="Move">
                    <p><input name="idCap" type="radio" class="id-radio-button" value="<%=row.getIdCaptain()%>" checked>
                        <p><%--<%=row.getIdRequest()%>--%> </p>
                    <%-- <input type="text" class="text-box" name="<%=row.getIdRequest()%>">--%>


                </form>

            </td>

            <%}} %>

        </tr>
    </table>

    <form action="dispatcher-page.jsp" method="get">
        <input type="submit" class="button" value="Назад">
    </form>
</div>
</body>
</html>
