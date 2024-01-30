<jsp:useBean id="book" scope="request" type="com.code.empcrud.bookmanagement.model.Book"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Book Management System</title>
</head>
<body>
    <h1>Book management System</h1>
    <h2>
        <c:if test="${book != null}">
            Edit Book Information
        </c:if>
        <c:if test="${book == null}">
            Add New Book
        </c:if>
    </h2>
    <c:if test="${book != null}">
    <form action="update-book" method="post">
        </c:if>
        <c:if test="${book == null}">
        <form action = "register-book" method="post">
            </c:if>
                BookName : <input
                    type="text"
                    value="${book.getBookName()}"
                    name="name"><br/>
                BookEdition: <input
                    type="text"
                    value="${book.getBookEdition()}"
                    name="edition"><br/>
                BookPrice : <input
                    type="number"
                    value="${book.getBookPrice()}"
                    name="price"> <br/>
                <button type="submit">Submit</button>
        </form>
</body>
</html>
