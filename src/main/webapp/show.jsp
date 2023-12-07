<%@ page import="java.util.List" %>
<%@ page import="com.yourpackage.ToDoItem" %>
<%@ page import="com.yourpackage.ToDoList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show To-Do List</title>
</head>
<body>
    <h2>To-Do List:</h2>
    <%
        ToDoList todo = new ToDoList(/* pass your SessionFactory here */);
        List<ToDoItem> items = todo.getAllItems();
        for (ToDoItem item : items) {
            out.println(item.getId() + ". " + item.getDescription() + "<br>");
        }
    %>
</body>
</html>
