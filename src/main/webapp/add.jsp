<%@ page import="com.yourpackage.ToDoList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add To-Do Item</title>
</head>
<body>
    <h2>Add To-Do Item:</h2>
    <form action="AddItemServlet" method="post">
        <input type="text" name="description" required>
        <input type="submit" value="Add Item">
    </form>
</body>
</html>
