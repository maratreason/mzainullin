package ru.mzainullin.servlet.presentation;

import ru.mzainullin.servlet.logic.ValidateService;
import ru.mzainullin.servlet.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@WebListener
public class ServletListener implements ServletContextListener {

    private ValidateService users;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        final ServletContext servletContext = servletContextEvent.getServletContext();
        users = new ValidateService().getInstance();

        servletContext.setAttribute("users", users);
        final User user = new User("sam", "samuel", "sam@mail.ru", new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()));
        users.addUser(user);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        users = null;
    }
}
