package com.yourpackage.servlets;

import com.yourpackage.HibernateUtil;
import com.yourpackage.ToDoList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteItemServlet")
public class DeleteItemServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int itemId = Integer.parseInt(request.getParameter("id"));

        // Perform validation if needed

        // Pass the Hibernate SessionFactory here (initialized through a context listener)
        ToDoList todo = new ToDoList(HibernateUtil.getSessionFactory());
        todo.deleteItem(itemId);

        // Redirect to the ShowListServlet after deleting the item
        response.sendRedirect("ShowListServlet");
    }
}
