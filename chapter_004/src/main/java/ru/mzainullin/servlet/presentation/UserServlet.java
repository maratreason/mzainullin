package ru.mzainullin.servlet.presentation;

import ru.mzainullin.servlet.logic.Validate;
import ru.mzainullin.servlet.logic.ValidateService;
import ru.mzainullin.servlet.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class UserServlet extends HttpServlet {

    /**
     * Список пользователей
     */
    private List<User> users = new ValidateService().getUsers();

    private final Validate logic = ValidateService.getInstance();


    @Override
    public void init() {
        User alex = new User(1, "alex", "alex", "alex@mail.ru", new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()));
        User marina = new User(2, "marina", "mary", "mary@mail.ru", new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()));

        this.users.add(alex);
        this.users.add(marina);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String date = req.getParameter("date");

        this.users.add(new User(id, name, login, email, date));

        PrintWriter writer = new PrintWriter(resp.getOutputStream());

        for (User user : this.users) {
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

        int getId = Integer.parseInt(req.getParameter("id"));

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String date = req.getParameter("date");
//        String date = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(Calendar.getInstance().getTime());

        switch (action) {
            case "add":
                System.out.println("Выбрана функция добавления");
                new ValidateService().addUser(new User(id, name, login, email, date));
                break;
            case "update":
                System.out.println("Выбрана функция обновления");
                new ValidateService().updateUser(getId, new User(getId, name, login, email, date));
                break;
            case "delete":
                System.out.println("Выбрана функция удаления");
                new ValidateService().deleteUser(getId);
                break;
            case "findById":
                System.out.println("Выбрана функция выбора пользователей по id");
                new ValidateService().findById(getId);
                break;
            case "findAll":
                System.out.println("Выбрана функция выбора всех пользователей");
                new ValidateService().findAll();
                break;
            default:
                System.out.println("Не выбрана ни одна функция");
        }

    }

}
