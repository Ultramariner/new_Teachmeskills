<%--
  Created by IntelliJ IDEA.
  User: artyo
  Date: 31.07.2022
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Books</title>
</head>
<body>
    <form method="GET" action="/lesson31/book/search">
        Name or Author:<input type="text" name="searchExpression"/>
        <input type="submit" value="Search"/>
    </form>
    <form method="POST" action="/lesson31/book/add">
        Name:<input type="text" name="name"/>${name}
        Genre:<input type="text" name="genre"/>
        Author:<input type="text" name="author"/>${author}
        Pages:<input type="number" name="pages"/>
        <input type="submit" value="Add"/>${error}
    </form>
    <c:forEach items="${books}" var="book">
        <c:out value = "${book.name}"/>
        <c:out value = "${book.genre}"/>
        <c:out value = "${book.author}"/>
        <c:out value = "${book.pages}"/><p>
    </c:forEach>
</body>
</html>
