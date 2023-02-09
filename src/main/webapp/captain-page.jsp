<%@ page import="java.io.PrintWriter" %>
<%@ page import="ru.rsreu.datalayer.DAO.DAOFactory" %>
<%@ page import="ru.rsreu.datalayer.DAO.DBType" %>
<%@ page import="ru.rsreu.datalayer.DAO.RequestsDAO" %>
<%@ page import="ru.rsreu.datalayer.data.Request" %>
<%@ page import="ru.rsreu.datalayer.data.RequestStatus" %><%--
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
        <h1><a href="index.jsp">Главная страница</a></h1>
    </div>
    <div>id = ${idUser}</div>
</div>
<div>
    <%
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        RequestsDAO requestsDAO = factory.getRequestsDAO();
        Request lastCapRequest = requestsDAO.getLastRequestById((Integer) request.getSession().getAttribute("idUser"));

        if ((lastCapRequest != null) && (!lastCapRequest.getRequestStatus().equals(RequestStatus.ACCEPTED) &&
                !lastCapRequest.getRequestStatus().equals(RequestStatus.DENIED))) {%>
    <%= "Your last request is in consideration" %>
    <%
    } else {
        if ((lastCapRequest != null) && (lastCapRequest.getRequestStatus().equals(RequestStatus.ACCEPTED))) {
    %>
    <%--Vrode vstavil, id =--%>
    <%= "Your last request : " + lastCapRequest.getIdRequest() + " was accepted"%>
    <%
        PrintWriter printWriter = response.getWriter();
        printWriter.println(" <form action=\"HelloServlet\" method=\"post\">\n" +
                "            <input type=\"submit\" class=\"button\" name=\"command\" value=\"Lead\">\n" +
                "            <input type=\"submit\" class=\"button\" name=\"command\" value=\"Transmit\">\n" +
                "        </form>");
    } else {
        if ((lastCapRequest != null)) {

    %>
    <%= "Your last request : " + lastCapRequest.getIdRequest() + " was denied"%>
    <%
                }
            }
        }
    %>
</div>
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
