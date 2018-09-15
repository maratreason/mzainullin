package ru.mzainullin.testsql.magnit;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 01.09.2018
 */
public class StoreSQL {

    Connection conn;
    private Config config;

    List<Entry> fields = new LinkedList<>();

    public void configSQL() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:d:/program files/SQLlite/databases/entry.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Метод генерации чисел
     * @param n - сгенерированное число
     * @return - число
     */
    public int generate(int n) {
        int result = 1;
        while (result <= n) {
            System.out.println("Вставляются данные: " + result);
            try {
                String query = "INSERT INTO entry (field) VALUES (" + result + ");";
                Statement st = conn.createStatement();
                st.executeUpdate(query);
                st.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
            fields.add(new Entry(result));
            result++;
        }
        return result;
    }


    /**
     * Метод создания таблицы entry
     * Если таблица не существует,
     * то создается.
     */
    public void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS entry (field INTEGER)";
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            st.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Таблица успешно создана");
    }


    /**
     * Метод отображения всех данных из таблицы entry
     */
    public void showTable() {
        try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM entry");
            System.out.println("+--- Show all fields ---+");
            while (res.next()) {
                System.out.println(String.format("field: %d",res.getInt("field")));
            }
            res.close();
            st.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return;
    }


    /**
     * Метод получения данных из таблицы entry
     */
    public void getFields() {
        try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT field FROM entry");
            while (res.next()) {
                int num = res.getInt("field");
                for (int i = 0; i != fields.size(); i++) {
                    fields.get(i).setField(num);
                }
            }
            res.close();
            st.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Метод удаления таблицы
     */
    public void dropTable() {
        try {
            String query = "DROP TABLE IF EXISTS entry;";
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            st.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }


    public void getInput() {
        System.out.println("Выберите пункт меню от 1 до 2...\n");
        System.out.println("1. Показать все данные из таблицы.");
        System.out.println("2. Сгенерировать данные в таблицу.");
        Scanner scn = new Scanner(System.in);
        int x = 1;
        while (x <= 3) {
            while (scn.hasNext()) {
                x = Integer.parseInt(scn.nextLine());
                switch (x) {
                    case 1:
                        showTable();
                        getInput();
                        break;
                    case 2:
                        generate(5);
                        getInput();
                        break;
                    default:
                        System.out.println("Вы ввели неверный номер");
                        getInput();
                        break;
                }
            }
        }
    }


    public static void main(String[] args) {
        StoreSQL store = new StoreSQL();
        store.configSQL();
        store.getInput();
    }
}