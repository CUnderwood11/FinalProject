<%@ page import="com.yourpackage.ToDoList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete To-Do Item</title>
</head>
<body>
    <h2>Delete To-Do Item:</h2>
    <form action="DeleteItemServlet" method="post">
        <input type="number" name="id" required>
        <input type="submit" value="Delete Item">
    </form>
</body>
</html>
