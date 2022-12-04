<%@ page import="ru.rsreu.datalayer.data.User" %>
<%@ page import="ru.rsreu.datalayer.handlers.AdminActionHandler" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 20.11.2022
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Админ</title>
    <style>
        <jsp:include page="css/style.css"/>
    </style>
</head>
<body>
<div class="main-container">
    <div class="registration-block">
        <h1>Регистрация нового пользователя</h1>
        <form action="registration.jsp" method="post">
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
                    <div class="choose-radio-container">
                        <p><b>Выберите тип пользователя</b></p>
                        <p><input name="usertype" type="radio" class="radio-button" value="admin"> Админ</p>
                        <p><input name="usertype" type="radio" class="radio-button" value="moderator"> Модератор </p>
                        <p><input name="usertype" type="radio" class="radio-button" value="user" checked> Пользователь
                        </p>
                    </div>


                </tr>
                <tr>
                    <td><input type="submit" class="button" value="Зарегестрировать"></td>
                    <td><input type="reset" class="button" value="Отмена"></td>
                </tr>
            </table>
        </form>
    </div>



    <div class="registration-block">
        <h1>Регистрация нового работника</h1>
        <form action="registration-worker.jsp" method="post">
            <table>
                <tr>
                    <td>id пользователя</td>
                    <td><input type="text" class="text-box" name="userId"></td>
                </tr>
                <tr>
                    <td>ФИО</td>
                    <td><input type="text" class="text-box" name="FIO"></td>
                </tr>
                <tr>
                    <div class="choose-radio-container">
                        <p><b>Выберите тип пользователя</b></p>
                        <p><input name="worker-type" type="radio" class="radio-button" value="captain" checked> Капитан</p>
                        <p><input name="worker-type" type="radio" class="radio-button" value="dispatcher"> Диспетчер </p>
                        <p><input name="worker-type" type="radio" class="radio-button" value="pilot" > Лоцман
                        </p>
                    </div>


                </tr>
                <tr>
                    <td><input type="submit" class="button" value="Зарегестрировать"></td>
                    <td><input type="reset" class="button" value="Отмена"></td>

                </tr>
            </table>

        </form>
    </div>


    <div class="info-selection-and-update-container">
        <div class="select-info-block">
            <h1>Просмотр информации </h1>
            <form action="user-table.jsp">
                <input type="submit" class="button" value="Таблица пользователей"></td>
            </form>
            <form action="workers-table.jsp">
                <input type="submit" class="button" value="Таблица работников"></td>
            </form>
            <form action="piers-table.jsp">
                <input type="submit" class="button" value="Таблица пирсов"></td>
            </form>
        </div>

        <div class="delete-info-block">
            <h1> Удаление информации</h1>
            <form action="DeleteUser" method="post">
                <input type="submit" class="button" value="Удалить пользователей"></td>
            </form>
            <form action="DeleteWorker" method="post">
                <input type="submit" class="button" value="Удалить работников"></td>
            </form>
        </div>

    </div>
</div>
</body>
</html>
