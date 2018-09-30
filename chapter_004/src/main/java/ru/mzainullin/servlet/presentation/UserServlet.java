package ru.mzainullin.servlet.presentation;

import ru.mzainullin.servlet.logic.Service;
import ru.mzainullin.servlet.model.User;
import ru.mzainullin.servlet.persistent.Storage;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class UserServlet extends HttpServlet {

    private List<User> users = new Service().getUsers();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

        users.add(new User(id, name, login, email, date));

        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        for(User user : this.users) {
            writer.append(String.format("id: %d, name: %s, login: %s, email: %s, date: %s",
                    user.getId(), user.getName(), user.getLogin(), user.getEmail(), user.getCreateDate()));
            writer.append("<br>");
        }

        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        doGet(req, resp);

        String action = req.getParameter("action");

        int getId = Integer.parseInt(req.getParameter("getId"));

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String date = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(Calendar.getInstance().getTime());

        switch (action) {
            case "add":
                System.out.println("Выбрана функция добавления");
                new Service().addUser(new User(id, name, login, email, date));
                break;
            case "update":
                System.out.println("Выбрана функция обновления");
                int newId = getId;
                new Service().updateUser(getId, new User(newId, name, login, email, date));
                break;
            case "delete":
                System.out.println("Выбрана функция удаления");
                new Service().deleteUser(getId);
                break;
        }
    }

}
