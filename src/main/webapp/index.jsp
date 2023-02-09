<%@ page import="java.io.PrintWriter" %>
<%@ page import="ru.rsreu.datalayer.data.User" %>
<%@ page import="ru.rsreu.datalayer.handlers.AdminActionHandler" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<!DOCTYPE html>
<html>
<head>
    <title>Порт: главная страница</title>
    <style>
        <jsp:include page="css/style.css"/>
    </style>
</head>
<body>
<div id="header">

    <div>
        <h1><a href="index.jsp">Главная страница</a></h1>
     </div>
    <div class="login-id">
        <%
            boolean isLoggedIn = false;
            if (request.getSession().getAttribute("idUser") == null) {
                request.setAttribute("LoginButtonValue", "Login");

            } else {
                request.setAttribute("LoginButtonValue", "Logout");
                isLoggedIn = true;
            }
            /*String logAction = isLoggedIn ? "login.jsp" : ""*/
            request.setAttribute("isAuthorized", Boolean.toString(isLoggedIn));
            if (isLoggedIn) {
                request.setAttribute("action", "HelloServlet");//for logout
                //request.getSession().invalidate();
            } else{
                request.setAttribute("action", "login.jsp");
            }
        %>
       <%-- <form action="login.jsp" method="post">--%>
        <form action="${action}" method="post">
            <input type="submit" class="button" name="command" value="${LoginButtonValue}"></td>
        </form>



        <%-- <% }%>--%>
    </div>
    <div>id =  ${idUser}</div>

</div>
<%--<div class="block-dark">
    <div class="actor-page-choice">
        <form action="admin-page.jsp">
            <input type="submit" class="button" value="Меню администратора"></td>
        </form>
        <form action="captain-page.jsp">
            <input type="submit" class="button" value="Меню капитана"></td>
        </form>
        <form action="dispatcher-page.jsp">
            <input type="submit" class="button" value="Меню диспетчера"></td>
        </form>
        <form action="moder-page.jsp">
            <input type="submit" class="button" value="Меню модера"></td>
        </form>
        <form action="piers-table.jsp">
            <input type="submit" class="button" value="piers"></td>
        </form>
        <form action="pilot-page.jsp">
            <input type="submit" class="button" value="pilot"></td>
        </form>
    </div>--%>
</div>

</body>
</html>