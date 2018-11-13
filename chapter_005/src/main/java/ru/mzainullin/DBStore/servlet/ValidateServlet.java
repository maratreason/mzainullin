package ru.mzainullin.DBStore.servlet;

import ru.mzainullin.DBStore.service.DBStore;
import ru.mzainullin.DBStore.model.Store;

import javax.servlet.http.HttpServlet;

/**
 * Помните. здесь мы ничего не изменяем в нашем коде. только добавляем новый класс.
 и меняем ссылку
 */

public class ValidateServlet extends HttpServlet {
    private final Store store = DBStore.getInstance();
}
