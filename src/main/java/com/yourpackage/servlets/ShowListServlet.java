package com.yourpackage.servlets;

import com.yourpackage.HibernateUtil;
import com.yourpackage.ToDoList;
import com.yourpackage.ToDoItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShowListServlet")
public class ShowListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pass the Hibernate SessionFactory here (initialized through a context listener)
        ToDoList todo = new ToDoList(HibernateUtil.getSessionFactory());
        List<ToDoItem> items = todo.getAllItems();

        // Store the list in request attribute to be accessed by the JSP page
        request.setAttribute("items", items);

        // Forward the request to the show.jsp page for displaying the list
        request.getRequestDispatcher("show.jsp").forward(request, response);
    }
}
