package com.yourpackage;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class HibernateContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        HibernateUtil.getSessionFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        HibernateUtil.closeSessionFactory();
    }
}
