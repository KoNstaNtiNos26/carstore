<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<h2>Страница добавления, обновления или удаления записи</h2>
<h3>Для добавления записи заполните форму:</h3>
<form action="${pageContext.request.contextPath}/store/add" method="post">
    модель <input type="text" name="carModel"/><br/>
    год производства <input type="text" name="year"/><br/>
    производитель <input type="text" name="producer"/><br/>
    кузов <input type="text" name="bodyWork"/><br/>
    <input type="submit" value="добавить"/>
    <c:if test="${id > 0}"><h3>запись с ключом <c:out value="${id}"/> успешно добавлена</h3></c:if>
    <c:if test="${id < 0}"><h3>запись не добавлена</h3></c:if>
</form>
<h3>для обновления данных обязательно укажите ключ записи. Заполните только изменяемые поля</h3>
<form action="${pageContext.request.contextPath}/store/update" method="post" onsubmit="sub();">
    ключ <input type="text" name="id"/><br/>
    модель <input type="text" name="carmod"/><br/>
    год производства <input type="text" name="yearproduce"/><br/>
    производитель <input type="text" name="producer"/><br/>
    кузов <input type="text" name="bodywork"/><br/>
    <input type="submit" value="обновить"/>
</form>
<h3><c:out value="${reason}"/></h3>
<script type="text/javascript">
    function sub() {
        var elementsByTagNameElement = document.forms[1].getElementsByTagName("input")[0];
        if(elementsByTagNameElement["value"] === "") elementsByTagNameElement["value"] = "-1";
    }
</script>
<h3>для удаления записи укажите ключ записи</h3>
<form action="${pageContext.request.contextPath}/store/del" method="get">
    ключ <input type="text" name="id"/><br/>
    <input type="submit" value="удалить"/>
</form>
<a href="${pageContext.request.contextPath}/store/all">Посмотреть все записи</a>
</body>
</html>
