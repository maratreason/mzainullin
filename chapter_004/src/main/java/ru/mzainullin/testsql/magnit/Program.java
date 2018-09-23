package ru.mzainullin.testsql.magnit;

import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 * Класс запуска программы
 */
public class Program {

    StoreSQL storeSQL;

    /**
     * Метод для работы с базой данных и XML-данными
     */
    public void startSQLProgram() throws Exception {
        StoreSQL store = new StoreSQL();
        store.configSQL();
        store.getInput();
    }

    public static void main(String[] args) throws Exception {
        new Program().startSQLProgram();
    }
}
