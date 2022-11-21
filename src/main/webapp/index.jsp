<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Порт: начальная страница</title>
</head>
<body>
<h1><%= "Main page!" %>
</h1>
<br/>
<a href="hello-servlet">Вывод данных из бд</a>
<br/>
<a href="admin-page.jsp">Зарегестрировать нового пользователя</a>
<jsp:useBean id = "calendar" class = "java.util.GregorianCalendar"/>
<form name="Simple" action="timeaction" method="POST">
<input type = "hidden" name = "time" value = "${calendar.timeInMillis}"/>
        <input type = "submit" name = "button" value = "Посчитать время"/>
</form>
</body>
</html>