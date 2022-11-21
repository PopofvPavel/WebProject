<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 20.11.2022
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Регистрация нового пользователя</title>
</head>
<body>
<form name="test" method="post" >
    <p><b>Введите логин:</b><br>
        <label>
            <input type="text" size="40">
        </label>
    </p>
    <p><b>Введите пароль:</b><br>
        <label>
            <input type="text" size="40">
        </label>
    </p>
</form>
<%--    <p><b>Выберите тип пользователя:</b><Br>--%>
<%--        <label>--%>
<%--            <input type="radio" name="usertype" value="admin" >--%>
<%--        </label> Admin<Br>--%>
<%--        <label>--%>
<%--            <input type="radio" name="usertype" value="moder">--%>
<%--        </label> Moder<Br>--%>
<%--        <label>--%>
<%--            <input type="radio" name="usertype" value="user">--%>
<%--        </label> User<Br>--%>
<%--    </p>--%>
<%--    <p><input type="submit" value="Зарегистрировать" > </p>--%>
    <form action="${pageContext.request.contextPath}/hello-servlet" method="post">
        <input type="submit" name="button1" value="Button 1" />
        <input type="submit" name="button2" value="Button 2" />
        <input type="submit" name="button3" value="Button 3" />
    </form>
<form action="${pageContext.request.contextPath}/hello-servlet" method="post">
    <input type="submit" name="buttonNewRequest" value="newRequest" />

</form>

</body>
</html>
