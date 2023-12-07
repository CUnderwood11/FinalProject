package com.yourpackage;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class ToDoListApp {
    public static void main(String[] args) {
        // Hibernate setup
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(com.yourpackage.ToDoItem.class)
                .buildSessionFactory();

        try {
            ToDoList todo = new ToDoList(factory);

            int flag = 0;
            while (flag == 0) {
                System.out.print("\n----------To-Do List----------\n\n1. Add item\n2. Delete item\n3. List items\n4. Exit\nEnter your choice: ");
                Scanner input = new Scanner(System.in);
                int option = input.nextInt();
                input.nextLine();

                switch (option) {
                    case 1:
                        System.out.println("Enter the item:");
                        String itemDescription = input.nextLine();
                        todo.addItem(itemDescription);
                        System.out.println("1 item added!");
                        break;
                    case 2:
                        todo.getAllItems();
                        System.out.println("Enter item number to delete:");
                        int itemIdToDelete = input.nextInt();
                        input.nextLine();
                        todo.deleteItem(itemIdToDelete);
                        System.out.println("1 item deleted!");
                        break;
                    case 3:
                        todo.getAllItems();
                        break;
                    case 4:
                        flag = 1;
                        break;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                }
            }
        } finally {
            factory.close();
        }
    }
}
