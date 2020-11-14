<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>

<table border="1">
    <thead>
    <th>Tytuł</th>
    <th>Autor</th>
    <th>Gatunek</th>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td><c:out value="${book.type}"/></td>
            <td>
                <button><a href="/admin/books/edit/${book.id}">Edytuj</a></button>
            </td>

        </tr>

    </c:forEach>
    </tbody>
</table>
<button><a href="/admin/books/add">Dodaj nową książkę</a></button>
</body>
</html>