package ru.mzainullin.testsql.magnit.config;

import java.sql.*;

/**
 * Класс подключения к базе данных
 *
 * @author Marat Zainullin
 * @version 1.0
 * @since 01.09.2018
 */
public class Config {
    Connection conn;

    public void open() {

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:d:/program files/SQLlite/databases/store.db");
            System.out.println("Мы подключились");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void close() {
        try {
            conn.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

}