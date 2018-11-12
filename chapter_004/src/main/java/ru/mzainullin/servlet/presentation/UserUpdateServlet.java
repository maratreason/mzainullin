package ru.mzainullin.servlet.presentation;

import ru.mzainullin.servlet.logic.ValidateService;
import ru.mzainullin.servlet.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UserUpdateServlet extends HttpServlet {

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        req.setAttribute("users", users);
        req.getRequestDispatcher("/WEB-INF/view/edit.jsp").forward(req, resp);
        resp.sendRedirect(req.getContextPath() + "/list");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        int id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String date = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(Calendar.getInstance().getTime());

        User user = new User(name, login, email, date);
        user.setId(id);

        if (user.getName() != null) {
            ValidateService.getInstance().updateUser(id, user);
            resp.sendRedirect(req.getContextPath() + "/list");
        } else {
            resp.sendRedirect(req.getContextPath() + "/edit");
        }

    }

}
