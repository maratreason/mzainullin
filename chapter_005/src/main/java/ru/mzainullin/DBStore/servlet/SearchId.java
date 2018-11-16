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

public class SearchId extends HttpServlet {
    private final Store store = DBStore.getInstance();

    @Override
    public void init() throws ServletException {
        Connection storeConnection = DBStore.getInstance().getSQLConnect();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setAttribute("store", store);
        req.getRequestDispatcher("/WEB-INF/views/searchId.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String id = req.getParameter("id");

        String someId = store.findById(id);

        if (someId.equals(id)) {
            resp.sendRedirect(String.format("%s/searchId?id=%s", req.getContextPath(), id));
//            resp.sendRedirect(String.format("%s/searchId", req.getContextPath()));
        } else {
            resp.sendRedirect(String.format("%s/", req.getContextPath()));
        }


    }
}
