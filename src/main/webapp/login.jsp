<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 07.12.2022
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        <jsp:include page="css/style.css"/>
    </style>
</head>
<body>
<div class="main-container">
    <div>id =  ${idUser}</div>
    <div class="registration-block">
        <h1>Login</h1>
        <form action="HelloServlet" method="post">
            <table>
                <tr>
                    <td>Логин</td>
                    <td><input type="text" class="text-box" name="userLogin"></td>
                </tr>
                <tr>
                    <td>Пароль</td>
                    <td><input type="text" class="text-box" name="userPassword"></td>
                </tr>
                <tr>
                  <%--  <% boolean isAuthorized%>--%>
                    <td><input type="submit" name="command" class="button" value="Login"></td>
                    <td><input type="reset" class="button" value="Cancel"></td>
                </tr>
            </table>
        </form>
    </div>

</div>

</body>
</html>
