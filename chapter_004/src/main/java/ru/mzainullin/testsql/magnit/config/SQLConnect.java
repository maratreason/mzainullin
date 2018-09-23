package ru.mzainullin.testsql.magnit.config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Marat Zainullin
 * @version 1.1
 * @since 23.09.2018
 */
public class SQLConnect {

    private Connection conn;

    /**
     * Соединение с базой данных
     */
    public Connection getConnectSQL() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:d:/program files/SQLlite/databases/entry.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}
