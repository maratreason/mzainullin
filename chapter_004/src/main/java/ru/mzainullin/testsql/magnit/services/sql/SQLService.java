package ru.mzainullin.testsql.magnit.services.sql;

import ru.mzainullin.testsql.magnit.config.SQLConnect;
import ru.mzainullin.testsql.magnit.model.Entry;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Marat Zainullin
 * @version 1.1
 * @since 23.09.2018
 */
public class SQLService {

    Connection conn = new SQLConnect().getConnectSQL();
    List<Entry> fields = new LinkedList<>();

    /**
     * Метод генерации чисел
     * @param n - сгенерированное число
     * @return - число
     */
    public int generate(int n) {
        clearData();
        int result = 1;
        while (result <= n) {
            System.out.println("Вставляются данные: " + result);
            try {
                String query = "INSERT INTO entry (field) VALUES (" + result + ");";
                Statement st = conn.createStatement();

                st.executeUpdate(query);
                this.fields.add(new Entry(result));
                st.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
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
    public List<Entry> getFields(List<Entry> newList) {
        int fieldValue;
        try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM entry");
            while (res.next()) {
                fieldValue = res.getInt("field");
                newList.add(new Entry());
                for (int i = 0; i < newList.size(); i++) {
                    newList.get(i).setField(fieldValue);
                    this.fields.add(newList.get(i));
                    System.out.println(newList.get(i).getField());
                    break;
                }
            }
            res.close();
            st.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return newList;
    }

    /**
     * Метод получения листа объектов.
     * @return лист
     */
    public List<Entry> getLists() {
        try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM entry");
            this.fields.clear();
            while (res.next()) {
                Entry entry = new Entry();
                entry.setField(res.getInt("field"));
                this.fields.add(entry);
            }
            res.close();
            st.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        System.out.println("The list's size is " + this.fields.size());
        return this.fields;
    }


    /**
     * Метод удаления таблицы
     */
    public void clearData() {
        try {
            String query = "DELETE FROM entry;";
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            st.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
