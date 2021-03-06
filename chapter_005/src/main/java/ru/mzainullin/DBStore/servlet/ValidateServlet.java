package ru.mzainullin.DBStore.servlet;

import ru.mzainullin.DBStore.service.DBStore;
import ru.mzainullin.DBStore.model.Store;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ValidateServlet extends HttpServlet {
    private final Store store = DBStore.getInstance();

    @Override
    public void init() throws ServletException {
        Connection storeConnection = DBStore.getInstance().getSQLConnect();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setAttribute("store", store);
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        store.findAll();
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
