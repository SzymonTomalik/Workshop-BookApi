<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Delete Book</title>
</head>
<body>
<form:form method="post" modelAttribute="book" action="/admin/books/delete/${id}">
    <td>Czy na pewno chcesz usunąć tę książkę?</td><br/>
    <form:hidden path="id"/><br/>
    Isbn:
    <form:input readonly="true" path="isbn" id="isbn"/><br/>
    Tytuł:
    <form:input readonly="true" path="title" id="title"/><br/>
    Autor:
    <form:input readonly="true" path="author" id="author"/><br/>
    Wydawca:
    <form:input readonly="true" path="publisher" id="publisher"/><br/>
    Gatunek:
    <form:input readonly="true" path="type" id="type"/><br/>
    <button><a href="/admin/books/all">Anuluj</a></button>

    <input type="submit" value="Usuń książkę">
</form:form>

</body>
</html>
