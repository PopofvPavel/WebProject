<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 05.12.2022
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Кэп</title>
    <style>
        <jsp:include page="css/style.css"/>
    </style>
</head>
<body>

<%--<div id="header">
    <div>
        <h1><a href="index.jsp">Главная страница main </a></h1>
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
/*        if (isLoggedIn && request.getParameter("LoginButtonValue").equals("Logout")) {

            request.getSession().invalidate();
        }*/
        %>
        <form action="login.jsp">
            <input type="submit" class="button" value="${LoginButtonValue}"></td>
        </form>


        &lt;%&ndash; <% }%>&ndash;%&gt;
    </div>
    <div>id = ${idUser}</div>
</div>--%>

<div id="header">

    <div>
        <h1><a href="index.jsp">Главная страница main gg</a></h1>
    </div>
    <%--<div class="login-id">
        <%
            boolean isLoggedIn = false;
            if (request.getSession().getAttribute("idUser") == null) {
                request.setAttribute("LoginButtonValue", request.getAttribute("idUser"));



            } else {
                request.setAttribute("LoginButtonValue", "Logout");
                isLoggedIn = true;

            }
            /*String logAction = isLoggedIn ? "login.jsp" : ""*/
            request.setAttribute("isAuthorized", Boolean.toString(isLoggedIn));
            if (isLoggedIn && request.getParameter("LoginButtonValue").equals("Logout")) {
                request.setAttribute("action", "HelloServlet");
                //request.getSession().invalidate();
            } else{
                request.setAttribute("action", "login.jsp");
            }
        %>
        &lt;%&ndash; <form action="login.jsp" method="post">&ndash;%&gt;
        <form action="${action}" method="post">
            <input type="submit" class="button" name="command" value="${LoginButtonValue}"></td>
        </form>

        <form action="HelloServlet" method="post">
            <input type="submit" class="button" name="command" value="DeleteUser"> id пользователя</td>
            <input type="text" class="text-box" name="id">
        </form>

        &lt;%&ndash; <% }%>&ndash;%&gt;
    </div>
    <div>id =  ${idUser}</div>
    <div> button value = ${LoginButtonValue}</div>--%>

</div>
<div>id =  ${idUser}</div>
<div class="block-dark">
    <h1>Новый запрос</h1>
    <form action="HelloServlet" method="post">
        <table>
            <tr>
                <div class="choose-radio-container">
                    <p><b>Выберите тип запроса</b></p>
                    <p><input name="request-type" type="radio" class="radio-button" value="arrival" checked> Прибытие
                    </p>
                    <p><input name="request-type" type="radio" class="radio-button" value="departure"> Отбытие </p>
                    </p>
                </div>
            </tr>
            <tr>
                <td><input type="submit" class="button" name="command" value="SendRequest"></td>
                <td><input type="reset" class="button" value="Отмена"></td>
            </tr>
        </table>

    </form>
</div>
</body>
</html>
