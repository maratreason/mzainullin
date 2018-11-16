package ru.mzainullin.DBStore.servlet;

import ru.mzainullin.DBStore.model.Store;
import ru.mzainullin.DBStore.service.DBStore;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class DeleteServlet extends HttpServlet {

    private final Store store = DBStore.getInstance();

    @Override
    public void init() {
        Connection storeConnection = DBStore.getInstance().getSQLConnect();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        store.delete(req.getParameter("id"));
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }

}
