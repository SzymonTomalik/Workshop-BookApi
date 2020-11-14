<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Book</title>
</head>
<body>
<form:form method="post" modelAttribute="book" action="/admin/books/edit">
    <form:hidden path="id" id="id" var="id"/>
    Isbn:
    <form:input path="isbn" id="isbn"/>
    <form:errors path="isbn"/><br/>
    Tytuł:
    <form:input path="title" id="title"/>
    <form:errors path="title"/><br/>
    Autor:
    <form:input path="author" id="author"/>
    <form:errors path="author"/><br/>
    Wydawca:
    <form:input path="publisher" id="publisher"/>
    <form:errors path="publisher"/><br/>
    Gatunek:
    <form:input path="type" id="type"/>
    <form:errors path="type"/><br/>

    <input type="submit" value="Save">
    <button><a href="/admin/books/delete/${id}">Usuń książkę</a></button>

</form:form>

</body>
</html>