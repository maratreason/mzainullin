package ru.mzainullin.servlet.presentation;

import ru.mzainullin.servlet.logic.ValidateService;
import ru.mzainullin.servlet.model.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UserCreateServlet extends HttpServlet {

    /**
     * Список пользователей
     */
    private ValidateService users;


    @Override
    public void init() {
        final Object users = getServletContext().getAttribute("users");
        this.users = (ValidateService) users;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        PrintWriter writer = new PrintWriter(resp.getOutputStream());

        StringBuilder stringBuilder = new StringBuilder("<table border='1'>");
        for (User user : this.users.findAll()) {
            stringBuilder.append("<tr>");
            stringBuilder.append("<td>" + user.getId() + "</td>");
            stringBuilder.append("<td>" + user.getName() + "</td>");
            stringBuilder.append("<td>" + user.getLogin() + "</td>");
            stringBuilder.append("<td>" + user.getEmail() + "</td>");
            stringBuilder.append("<td>" + user.getCreateDate() + "</td>");

            stringBuilder.append("<td><form action='/edit?id=" + user.getId() + "'>" +
                    "<input type='number' hidden name='id'>" +
                    "<input type='submit' name='id' value='Редактировать'>" +
                    "</form></td>");

            stringBuilder.append("<td><form action='/delete' method='post'>" +
                    "<input type='number' hidden name='id' value='" + user.getId() + "'>" +
                    "<input type='submit' value='Удалить'>" +
                    "</form></td>");
            stringBuilder.append("</tr>");
        }
        stringBuilder.append("</table>");

        writer.append("<html>\n" +
                "<head>\n" +
                "    <title>Create User</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action='" + req.getContextPath() + "/create' method='post'>" +
                "Name: <input type='text' name='name'>" +
                "Login: <input type='text' name='login'>" +
                "Email: <input type='text' name='email'>" +
                "<input type='submit'>" +
                "</form>" +
                "<br>" +
                stringBuilder.toString() +
                "</body>\n" +
                "</html>");

        writer.flush();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String date = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(Calendar.getInstance().getTime());

        User user = new User(name, login, email, date);

        if (user.getName() != null) {
            this.users.addUser(user);
        }

        doGet(req, resp);
    }

}
