package ru.mzainullin.testsql.magnit;

import javax.xml.bind.JAXBException;

/**
 * Класс запуска программы
 */
public class Program {

    StoreSQL storeSQL;

    /**
     * Метод для работы с базой данных и XML-данными
     */
    public void startSQLProgram() throws JAXBException {
        StoreSQL store = new StoreSQL();
        store.configSQL();
        store.getInput();
    }

    public static void main(String[] args) throws JAXBException {
        new Program().startSQLProgram();
    }
}
