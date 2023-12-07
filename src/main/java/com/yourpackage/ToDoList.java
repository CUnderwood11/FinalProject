package com.yourpackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ToDoList {
    private SessionFactory factory;

    public ToDoList(SessionFactory factory) {
        this.factory = factory;
    }

    public void addItem(String description) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            ToDoItem newItem = new ToDoItem();
            newItem.setDescription(description);

            session.save(newItem);

            session.getTransaction().commit();
        }
    }

    public void deleteItem(int id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            ToDoItem itemToDelete = session.get(ToDoItem.class, (long) id);
            if (itemToDelete != null) {
                session.delete(itemToDelete);
            }

            session.getTransaction().commit();
        }
    }

    public List<ToDoItem> getAllItems() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            List<ToDoItem> items = session.createQuery("from ToDoItem", ToDoItem.class).getResultList();

            session.getTransaction().commit();

            return items;
        }
    }
}
