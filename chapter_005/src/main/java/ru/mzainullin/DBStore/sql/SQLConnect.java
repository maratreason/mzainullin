package ru.mzainullin.DBStore.sql;

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
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBStore");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}
