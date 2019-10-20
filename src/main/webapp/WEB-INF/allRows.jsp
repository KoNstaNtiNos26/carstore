<%--
  Created by IntelliJ IDEA.
  User: Lyana
  Date: 20.10.2019
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Все записи таблицы</h3>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Model</th>
        <th>Producer</th>
        <th>Year</th>
        <th>Bodywork</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="row" items="${listCars}">
        <tr>
            <td><c:out value="${row.id}"/></td>
            <td><c:out value="${row.carmod}"/></td>
            <td><c:out value="${row.producer}"/></td>
            <td><c:out value="${row.yearproduce}"/></td>
            <td><c:out value="${row.bodywork}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="${pageContext.request.contextPath}/store">вернуться к редактированию списка</a>
</body>
</html>
