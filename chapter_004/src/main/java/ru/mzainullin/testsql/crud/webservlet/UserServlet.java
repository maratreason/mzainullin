package ru.mzainullin.testsql.crud.webservlet;

import ru.mzainullin.testsql.crud.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Marat Zainullin
 * @since 09.09.2018
 * @version 1.0
 */
public class UserServlet extends HttpServlet {

    private List<User> newUsers;

    public void init() throws ServletException {
        newUsers = new CopyOnWriteArrayList();
        newUsers.add(new User("Marat", "maratreason", "test@mail.ru", new Date()));
        newUsers.add(new User("Alena", "aleno4ka", "aleno4ka@mail.ru", new Date()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", newUsers);
        req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");

        final String id = req.getParameter("id");
        final String name = req.getParameter("name");
        final String login = req.getParameter("login");
        final String email = req.getParameter("email");
        final String date = req.getParameter("createDate");

        final User user = new User(name, login, email, new Date());
        newUsers.add(user);

        doGet(req, resp);
    }

}
