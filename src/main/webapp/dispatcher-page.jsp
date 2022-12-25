<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 06.12.2022
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>Диспетчер</title>
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

<div class="info-selection-and-update-container">
    <div class="select-info-block">
        <h1>Просмотр информации </h1>
        <h1>Your id is ${userId}</h1>
        <form action="requests-table.jsp">
            <input type="submit" class="button" value="Таблица запросов">
            <input type="checkbox" name="show-active" value="show" checked>Показать только активные запросы
        </form>
        <form action="piers-table.jsp">
            <input type="submit" class="button" value="Таблица пирсов">

        </form>>
    </div>

</div>
</body>
</html>
