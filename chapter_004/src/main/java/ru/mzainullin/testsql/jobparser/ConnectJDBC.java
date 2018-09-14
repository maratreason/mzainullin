package ru.mzainullin.testsql.jobparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import sun.rmi.runtime.Log;

import java.io.*;
import java.sql.*;
import java.util.*;

import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author Marat Zainullin
 * @since 14.06.2018
 */
public class ConnectJDBC {

    Connection conn = null;
    Properties defaultProps = new Properties();
    InputStream in;

    public ConnectJDBC(){}

    public ConnectJDBC(InputStream in) {
        try {
            /*in = ConnectJDBC.class
                    .getResourceAsStream(
                            "d:\\Projects\\mzainullin\\chapter_004\\src\\main\\java\\ru\\mzainullin\\testsql\\jobparser\\app.properties"
                    );*/

//            in = new FileInputStream("d:\\Projects\\mzainullin\\chapter_004\\src\\main\\java\\ru\\mzainullin\\testsql\\jobparser\\app.properties");
            defaultProps.load(in);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showDB() {

        String url = "jdbc:postgresql://localhost:5432/java_a_from_z";
        String username = "postgres";
        String password = "1111";
        Statement st = null;

        try {
//            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, username, password);
//            conn = DriverManager.getConnection(String.valueOf(new ConnectJDBC(in)));
            st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM workers;");
            while (res.next()) {
                System.out.println(String.format("id:%d, name:%s, status:%s",
                        res.getInt("id"),
                        res.getString("name"),
                        res.getString("status")
                ));
            }
            res.close();
            st.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
//        new ConnectJDBC().showDB();
//        new CronTrigger(newTrigger().build());
        Document doc = Jsoup.connect("http://www.sql.ru/forum/1302045/vakansiya-java-programmist?hl=java").get();
        String title = doc.title();
        String content = doc.text();
        System.out.println(title);
        System.out.println(content);
    }

}