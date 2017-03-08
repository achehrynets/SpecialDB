<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 04/03/17
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ include file="/WEB-INF/jspf/include.jspf"%>--%>
<%@ include file="/WEB-INF/jspf/include.jspf" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>orders</title>
    <link rel="stylesheet" href="/style/css/bootstrap.min.css">
</head>
<body>
    <%@include file="../jspf/menu.jspf"%>
    <h1>admin</h1>
    <table border="1">
        <thead>
        <tr>
            <th>id</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>День рождения</th>
            <th>login</th>
            <th>email</th>
            <th>телефон</th>
            <th>Роль</th>
            <th>Валидация</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cl" items="${listClients}">
            <tr>
                <td><c:out value="${cl.client_id}" /></td>
                <td><c:out value="${cl.name}" /></td>
                <td><c:out value="${cl.surname}" /></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${cl.birthday}" /></td>
                <td><c:out value="${cl.login}" /></td>
                <td><c:out value="${cl.email}" /></td>
                <td><c:out value="${cl.phone}" /></td>
                <td><c:out value="${cl.role}" /></td>
                <td>
                    <c:choose>
                        <c:when test="${cl.valid == true}">
                            +
                        </c:when>
                        <c:otherwise>
                            -
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
