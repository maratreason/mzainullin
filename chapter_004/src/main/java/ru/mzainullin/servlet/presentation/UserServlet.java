package ru.mzainullin.servlet.presentation;

import ru.mzainullin.servlet.logic.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class UserServlet extends HttpServlet {

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
        req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        ValidateService.getInstance().getUsers();
        resp.sendRedirect(String.format("%s/index.jsp", req.getContextPath()));
    }
}
