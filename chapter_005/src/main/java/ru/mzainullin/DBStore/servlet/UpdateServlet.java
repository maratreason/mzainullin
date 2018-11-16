package ru.mzainullin.DBStore.servlet;

import ru.mzainullin.DBStore.model.Store;
import ru.mzainullin.DBStore.model.User;
import ru.mzainullin.DBStore.service.DBStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class UpdateServlet extends HttpServlet {

    private final Store store = DBStore.getInstance();

    @Override
    public void init() throws ServletException {
        Connection storeConnection = DBStore.getInstance().getSQLConnect();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        req.setAttribute("store", store);
        req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
        resp.sendRedirect(req.getContextPath() + "/update");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        String id = req.getParameter("id");
        String name = req.getParameter("name");

        User user = new User(id, name);

        if (user.getName() != null) {
            store.update(id, user);
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            resp.sendRedirect(req.getContextPath() + "/update");
        }

    }

}
