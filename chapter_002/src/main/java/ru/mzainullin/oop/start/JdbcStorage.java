package ru.mzainullin.oop.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * @author Marat Zainullin
 * @since 04.06.2018
 */
public class JdbcStorage {
    private static final Logger Log = LoggerFactory.getLogger(JdbcStorage.class);

    public static void connectionDB() {

        String url = "jdbc:postgresql://localhost:5432/java_a_from_z";
        String username = "postgres";
        String password = "1111";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch(SQLException e) {
                    Log.error(e.getMessage(), e);
                }
            }
        }
    }

}
