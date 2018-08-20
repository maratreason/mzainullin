package ru.mzainullin.oop.start;

import ru.mzainullin.oop.models.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mzainullin.testsql.SQLStorage;

import java.sql.*;
import java.util.*;

/**
 * @author Marat Zainullin
 * @version 1.2
 * @since 07.05.2018
 */
public class Tracker implements AutoCloseable {

    private int position = 0;
    private static final Random RN = new Random();
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
    private List<Item> items = new ArrayList<>();
    ConnectDB connectDB = new ConnectDB();
    private static final Logger Log = LoggerFactory.getLogger(SQLStorage.class);


    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        String url = "jdbc:postgresql://localhost:5432/java_a_from_z";
        String username = "postgres";
        String password = "1111";
        Connection conn = null;

        try(PreparedStatement st = conn.prepareStatement("INSERT INTO items (description, name) values (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            conn = DriverManager.getConnection(url, username, password);
            st.setString(2, item.getName());
            st.setString(1, item.getDescription());
            st.executeUpdate();

            final ResultSet generatedKeys = st.getGeneratedKeys();

            if (generatedKeys.next()) {
                System.out.println(generatedKeys.getInt(1));
            }
            
        } catch(Exception e) {
            Log.error(e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch(SQLException e) {
                    Log.error(e.getMessage(), e);
                }
            }
        }

        return item;
    }


    /**
     * Новый метод перезаписи заявки по id
     * @param newId - перезапись
     */
    public void edit(Item newId) {

            String url = "jdbc:postgresql://localhost:5432/java_a_from_z";
            String username = "postgres";
            String password = "1111";
            Connection conn = null;

            try {
                conn = DriverManager.getConnection(url, username, password);
                PreparedStatement st = conn.prepareStatement("UPDATE items SET name=?, description=? WHERE id=?");

                for (int index = 0; index != items.size(); index++) {
                    Item item = items.get(index);
                    if (item != null && item.getId().equals(newId.getId())) {
                        items.set(index, newId);
                        st.setString(1, items.get(index).getName());
                        st.setString(2, items.get(index).getDescription());
                        st.setString(3, items.get(index).getId());
                        st.executeUpdate();
                        break;
                    }
                }

            } catch(Exception e) {
                Log.error(e.getMessage());
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


    /**
     * Метод реализаущий замену заявки по id
     * @param item новая заявка
     * @param id = номер id заявки
     */
    public void replace(String id, Item item) {
        for (int index = 0; index != this.position; index++) {
            if (items.get(index).getId().equals(id)) {
                items.get(index).setId(id);
                break;
            }
        }
    }


    /**
     * Метод реализаущий удаление заявки по id
     * @param id
     */
    public void delete(String id) {
        for (int index = 0; index != items.size() - 1; index++) {
            if (items.get(index).getId().equals(id)) {
                items.remove(index);
                break;
            }
        }
    }


    /**
     * Метод реализующий поиск всех имеющихся заявок
     * @return коллекция заявок
     */
    public List<Item> findAll() {
        List<Item> showItems = new ArrayList<>();
        for (Item item : items) {
            showItems.add(item);
        }

        String url = "jdbc:postgresql://localhost:5432/java_a_from_z";
        String username = "postgres";
        String password = "1111";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT id, name, description FROM items");
            while (res.next()) {
                System.out.println(String.format("%d %s %s", res.getInt("id"), res.getString("name"), res.getString("description")));
            }
            res.close();
            st.close();
        } catch(Exception e) {
            Log.error(e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch(SQLException e) {
                    Log.error(e.getMessage(), e);
                }
            }
        }

        return showItems;
    }


    /**
     * Метод реализующий поиск всех заявок по имени
     * @return текущее имя указанное в поиске
     */
    public List<Item> findByName(String key) {
        List<Item> item = new ArrayList<>();
        for (int index = 0; index != item.size(); index++) {
            if (item.get(index) != null && item.get(index).getName().equals(key)) {
                item.get(index);
            }
        }
        return item;
    }


    /**
     * Метод реализаущий поиск по идентификатору
     * @return result
     */
    public Item findById(String id) {
        Item item = new Item();
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index) != null && items.get(index).getId().equals(id)) {
                item = items.get(index);
                break;
            }
        }
        return item;
    }

    @Override
    public void close() throws Exception {

    }

}
