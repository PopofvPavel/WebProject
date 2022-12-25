<%@ page import="java.io.PrintWriter" %>
<%@ page import="ru.rsreu.datalayer.data.User" %>
<%@ page import="ru.rsreu.datalayer.handlers.AdminActionHandler" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.rsreu.datalayer.handlers.DispatcherActionHandler" %>
<%@ page import="ru.rsreu.datalayer.data.Request" %>
<%@ page import="ru.rsreu.datalayer.data.RequestStatus" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 06.12.2022
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Requests table</title>
    <style>
        <jsp:include page="css/style.css"/>
    </style>
</head>
<body>

<%--<div class="registration-block">
    <h1>Рассмотрение запроса</h1>
    <form action="HelloServlet" method="post">
        <table>
&lt;%&ndash;            <tr>
                <td>id Запроса</td>
                <td><input type="text" class="text-box" name="requestId"></td>
            </tr>&ndash;%&gt;
            <tr>
                <div class="choose-radio-container">
                    <p><b>Выберите тип статус запроса</b></p>
                    <p><input name="update-type" type="radio" class="radio-button" value="ACCEPTED" checked> Принять</p>
                    <p><input name="update-type" type="radio" class="radio-button" value="IN_WAITING"> В ожидание </p>
                    <p><input name="update-type" type="radio" class="radio-button" value="IN_CONSIDERATON" > В рассмотрение
                    <p><input name="update-type" type="radio" class="radio-button" value="DENIED" checked> Отклонить
                    </p>
                </div>


            </tr>
            <tr>
                <td><input type="submit" class="button" value="Зарегестрировать"></td>
                <td><input type="reset" class="button" value="Отмена"></td>
            </tr>
        </table>
    </form>
</div>--%>

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
            boolean isCheckedShowActive = request.getParameter("show-active") != null;
            PrintWriter printWriter = response.getWriter();
            List<Request> rows = DispatcherActionHandler.getAllRequestsList();
            for (Request row : rows) { if (isCheckedShowActive && (row.getRequestStatus().equals(RequestStatus.ACCEPTED)
                    || row.getRequestStatus().equals(RequestStatus.DENIED))){continue;}%>
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
                    <input type="submit" class="button" name="command" value="UpdateRequest">
                    <p><input name="idReq" type="radio" class="id-radio-button" value="<%=row.getIdRequest()%>" checked><%--<%=row.getIdRequest()%>--%> </p>
                       <div class="choose-radio-container">
                           <p><b>Выберите тип статус запроса</b></p>
                           <p><input name="update-type" type="radio" class="radio-button" value="ACCEPTED" checked> Принять</p>
                           <p><input name="update-type" type="radio" class="radio-button" value="IN_WAITING"> В ожидание </p>
                           <p><input name="update-type" type="radio" class="radio-button" value="IN_CONSIDERATON" > В рассмотрение
                           <p><input name="update-type" type="radio" class="radio-button" value="DENIED" > Отклонить
                           </p>
                       </div>
                       <%-- <input type="text" class="text-box" name="<%=row.getIdRequest()%>">--%>


                   </form>

            </td>

            <%} %>

        </tr>
    </table>

    <form action="dispatcher-page.jsp" method="get">
        <input type="submit" class="button" value="Назад">
    </form>
</div>
</body>
</html>
