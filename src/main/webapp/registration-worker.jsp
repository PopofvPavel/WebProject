<%@ page import="ru.rsreu.datalayer.handlers.AdminActionHandler" %>
<%@ page import="ru.rsreu.datalayer.handlers.SystemHandler" %>
<%@ page import="ru.rsreu.datalayer.data.User" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="ru.rsreu.datalayer.data.Post" %>
<%@ page import="ru.rsreu.datalayer.data.Worker" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 03.12.2022
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration worker</title>
    <style> <jsp:include page="css/style.css"/></style>

</head>
<body>
<div class="registration-block">
    <%
        int userId = Integer.parseInt(request.getParameter("userId"));
        String FIO = request.getParameter("FIO");
        boolean isCaptain = request.getParameter("worker-type").equals("captain");
        boolean isDispatcher = request.getParameter("worker-type").equals("dispatcher");
        String type = isCaptain ? "Капитан" : isDispatcher ? "Диспетчер" : "Лоцман";

        boolean isValidUserId = SystemHandler.isValidUserId(userId);
        //int newUserId = SystemHandler.getNewUserId();
        Post newWorkerPost = isCaptain ? Post.CAPTAIN : isDispatcher ? Post.DISPATCHER : Post.PILOT;
        Worker newWorker = new Worker(userId, newWorkerPost, FIO);


        PrintWriter printWriter = response.getWriter();
        if (request.getParameter("userId").isEmpty()) {%>

    <%= "Вы ввели пустой id"%>
    <%} else if (FIO.isEmpty()) {%>
    <%="Вы ввели пустое ФИО"%>
    <%
    } else if (isValidUserId) {

        AdminActionHandler.registerNewWorker(newWorker);
    %>
    <%= "Работник зарегистрирован:" + "<br>"%>
    <%="id: " + userId + "<br>" + "ФИО: " + FIO
            + "<br>" + "Пост: " + newWorkerPost + "<br>"%>

    <%} else {%>

    <%="Данный id не найден или не подходит по типу, попробуйте другой"%>
    <%}%>
    <form action="admin-page.jsp" method="get">
        <input type="submit" class="button" value="Назад">
    </form>
</div>

</body>
</html>
