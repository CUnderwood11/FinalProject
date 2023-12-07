package com.yourpackage.servlets;

import com.yourpackage.HibernateUtil;
import com.yourpackage.ToDoList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddItemServlet")
public class AddItemServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");

        // Perform validation if needed

        // Pass the Hibernate SessionFactory here (initialized through a context listener)
        ToDoList todo = new ToDoList(HibernateUtil.getSessionFactory());
        todo.addItem(description);

        // Redirect to the ShowListServlet after adding the item
        response.sendRedirect("ShowListServlet");
    }
}
