package ru.mzainullin.oop.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mzainullin.testsql.SQLStorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Marat Zainullin
 * @since 18.08.2018
 */
public class ConnectDB {

    private static final Logger Log = LoggerFactory.getLogger(SQLStorage.class);

    public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java_a_from_z", "postgres", "1111");
            System.out.println("Got our connection");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}