<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 04/03/17
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@include file="jspf/include.jspf"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" href="style/css/bootstrap.min.css"/>
</head>
<body>
    <%@include file="jspf/menu.jspf" %>
    <form class="sign-in" style="margin-top: 50px; margin-left: 100px; " action="/login" method="post">
    <div class="input-group">
        <span class="glyphicon glyphicon-user"></span>
        <input type="text" class="form-control" placeholder="Логин" name = "login">
    </div>
    <div class="input-group">
        <span class="glyphicon glyphicon-lock"></span>
        <input type="password" class="form-control" placeholder="пароль" name = "password">
    </div>
    <button type="submit">Войти</button>
    <div class="alert alert-danger, input-group">
        <a class="alert-link"><c:out value="${requestScope.errorMsg}" /></a>
    </div>
    </form>

    <%--<div class="container" style="margin-top: 50px; ">--%>
        <%--<div class="panel panel-primary registration-panel">--%>
            <%--<form class="form-signin" action="/login" method="post">--%>
                <%--LogIn:--%>
                <%--<input type="text" name="login" />--%>
                <%--Password:--%>
                <%--<input type="password" name="password" />--%>
                <%--<c:set var="errorMsg" scope="request" value="${requestScope.errorMsg}" />--%>
                <%--<div class="alert alert-danger">--%>
                    <%--<a class="alert-link"><c:out value="${requestScope.errorMsg}" /></a>--%>
                <%--</div>--%>
                <%--<button type="submit">вход</button>--%>
            <%--</form>--%>
        <%--</div>--%>
    <%--</div>--%>
</body>
</html>
