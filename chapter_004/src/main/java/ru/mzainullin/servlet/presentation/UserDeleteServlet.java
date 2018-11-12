package ru.mzainullin.servlet.presentation;

import ru.mzainullin.servlet.logic.ValidateService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserDeleteServlet extends HttpServlet {

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
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        ValidateService.getInstance().deleteUser(Integer.valueOf(req.getParameter("id")));
        resp.sendRedirect(String.format("%s/list", req.getContextPath()));
    }

}
