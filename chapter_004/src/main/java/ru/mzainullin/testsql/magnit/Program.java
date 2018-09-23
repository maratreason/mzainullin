package ru.mzainullin.testsql.magnit;

import ru.mzainullin.testsql.magnit.config.SQLConnect;
import ru.mzainullin.testsql.magnit.model.Menu;

/**
 * Класс запуска программы
 */
public class Program {
    public static void main(String[] args) throws Exception {
        new Menu().showMenu();
    }
}
