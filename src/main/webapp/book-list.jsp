<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.code.empcrud.bookmanagement.model.Book"  %>
<%@ page import="java.util.List" %>
<%@ page import="com.code.empcrud.bookmanagement.dao.BookDaoImpl" %>
<%@ page import="com.code.empcrud.bookmanagement.utils.DbConnection" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Booklist_Management</title>
</head>
<body>
    <h1>List of Books in the library</h1>
    <button type="button">
        <a href="Form.jsp">Add a book</a>
    </button>
    <table>
        <thead>
            <tr>
                <th>BookId</th>
                <th>BookName</th>
                <th>BookEdition</th>
                <th>BookPrice</th>
                <th>Actions</th>
            </tr>

        </thead>
        <tbody>
        <jsp:useBean id="books" scope="request" type="java.util.List"/>
        <c:forEach items = "${books}" var="book">

            <tr>
                <td><c:out value="${book.getId()}"></c:out></td>
                <td><c:out value="${book.getBookName()}"></c:out></td>
                <td><c:out value="${book.getBookEdition()}"></c:out></td>
                <td><c:out value="${book.getBookPrice()}"></c:out></td>
                <td>
                    <a href="editScreen-book?id=<c:out value='${book.id}'/>">Edit</a>
                    &nbsp;&nbsp;
                    <a href="delete-book?id=<c:out value='${book.id}'/> ">Delete</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</body>
</html>
