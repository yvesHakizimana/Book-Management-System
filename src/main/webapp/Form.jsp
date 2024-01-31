<%--
  Created by IntelliJ IDEA.
  User: cyberknight
  Date: 30/01/2024
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BookManagement</title>
</head>
<body>
    <h1>Book management System</h1>
    <form action="register-book" method="post">
        <p>Enter the book information: </p>
        BookName : <input type="text" name="name"><br/>
        BookEdition: <input type="text" name="edition"><br/>
        BookPrice : <input type="number" name="price"> <br/>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
