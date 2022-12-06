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
<div class="block-dark">
    <h1>Новый запрос</h1>
    <form action="HelloServlet" method="post">
        <table>
            <tr>
                <div class="choose-radio-container">
                    <p><b>Выберите тип запроса</b></p>
                    <p><input name="request-type" type="radio" class="radio-button" value="arrival" checked> Прибытие</p>
                    <p><input name="request-type" type="radio" class="radio-button" value="departure"> Отбытие </p>
                    </p>
                </div>
            </tr>
            <tr>
                <td><input type="submit" class="button" name="command" value="SendRequest"> </td>
                <td><input type="reset" class="button" value="Отмена"></td>
            </tr>
        </table>

    </form>
</div>
</body>
</html>
