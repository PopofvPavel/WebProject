<%@ page import="ru.rsreu.datalayer.DAO.AdminActionDAO" %>
<%@ page import="ru.rsreu.datalayer.data.UserInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.rsreu.datalayer.DAO.DAOFactory" %>
<%@ page import="ru.rsreu.datalayer.DAO.DBType" %>
<%@ page import="ru.rsreu.datalayer.handlers.AdminActionHandler" %>
<%@ page import="ru.rsreu.datalayer.handlers.SystemHandler" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="ru.rsreu.datalayer.data.User" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 28.11.2022
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <style>
        <jsp:include page="css/style.css"/>
    </style>
</head>
<body>
<div class="registration-block">
    <%
        String login = request.getParameter("userLogin");
        String password = request.getParameter("userPassword");
        boolean isAdmin = request.getParameter("usertype").equals("admin");
        boolean isModer = request.getParameter("usertype").equals("moderator");
        boolean isUser = request.getParameter("usertype").equals("user");
        String type = isAdmin ? "Админ" : isModer ? "Модер" : "Пользователь";

        // boolean isValidPassword = SystemHandler.isValidPassword(password);
        //System.out.println("pass valid = " + isValidPassword);
        boolean isValidLogin = SystemHandler.isValidLogin(login);
        int newUserId = SystemHandler.getNewUserId();
        int newIdUserType = isAdmin ? 1 : isModer ? 2 : 3;
        User newUser = new User(newUserId, newIdUserType, login, password, 0, 0);


        PrintWriter printWriter = response.getWriter();
        if (password.isEmpty()) {%>

    <%= "Вы ввели пустой пароль"%>
    <%} else if (login.isEmpty()) {%>
    <%="Вы ввели пустой логин"%>
    <%
    } else if (isValidLogin) {

        AdminActionHandler.registerNewUser(newUser);
    %>
    <%= "Пользователь зарегистрирован:" + "<br>"%>
    <%="Логин: " + login + "<br>" + "Пароль: " + password
    + "<br>" + "Тип: " + type + "<br>"%>

    <%} else {%>

    <%="Данный логин занят, попробуйте другой"%>
    <%}

    %>
    <%--<%="Login = " + login + "Password = " + password + "Valid log " + isValidLogin + "Valid pass " + isValidPassword%>--%>
    <form action="admin-page.jsp" method="get">
        <input type="submit" class="button" value="Назад">
    </form>
</div>

</body>
</html>
