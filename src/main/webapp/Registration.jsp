<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 20/02/17
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registration</title>
    <link href="style.css" rel="stylesheet" type="text/css" />
    <style>
        <%@include file="style.css" %>
    </style>
</head>
<body>
        <ul class="navbar">
            <li>
                <a href="#">Смартфоны и телефоны</a>
            </li>
            <li>
                <a href="#">Планшеты</a>
            </li>
            <li>
                <a href="#">Регистрация</a>
            </li>
            <li>
                <a href="#">О нас</a>
            </li>
        </ul>
    <form action="RegistrationServlet" method="post">
        First Name:
        <input type="text" name="userName"> <br>
        Last Name:
        <input type="text" name="userSurname"> <br>
        Birthday:
        <input type="date" name="birthday"> <br>
        Login:
        <input type="text" name="login"> <br>
        Password:
        <input type="password" name="password"> <br>
        Email:
        <input type="email" name="email"> <br>
        Tel. Phone:
        <input type="text" name="phone"> <br>

        <input type="submit" value="submit">
    </form>
</body>
</html>
