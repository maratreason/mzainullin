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

    private String url = "jdbc:postgresql://localhost:5432/java_a_from_z";
    private String username = "postgres";
    private String password = "1111";
    private Connection conn = null;


    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);

        try {
            conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = conn.prepareStatement("INSERT INTO items (name, description) values (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
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

            try {
                conn = DriverManager.getConnection(url, username, password);
                PreparedStatement st = conn.prepareStatement("UPDATE items SET name=?, description=? WHERE id=?");
                st.setString(1, newId.getName());
                st.setString(2, newId.getDescription());
                st.setInt(3, Integer.parseInt(newId.getId()));
                st.executeUpdate();
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
     * @param uid
     */
    public void delete(String uid) {
        try {
            conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = conn.prepareStatement("DELETE FROM items WHERE id = ?");
            st.setInt(1, Integer.parseInt(uid));
            st.executeUpdate();

        } catch(Exception e) {
            Log.error(e.getMessage(), e);
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
     * Метод реализующий поиск всех имеющихся заявок
     * @return коллекция заявок
     */
    public List<Item> findAll() {
        List<Item> showItems = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT id, name, description FROM items");
            while (res.next()) {
                System.out.println(String.format("%d %s %s",
                        res.getInt("id"),
                        res.getString("name"),
                        res.getString("description"))
                );
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
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getName().equals(key)) {
                item.add(items.get(index));
                break;
            }
        }

        try {
            conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = conn.prepareStatement("SELECT name FROM items WHERE name=?");
            st.setString(1, key);
            st.executeUpdate();
        } catch(Exception e) {
            Log.error(e.getMessage(), e);
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
     * Метод реализаущий поиск по идентификатору
     * @return item
     */
    public Item findById(String id) {
        Item item = new Item();

        try {
            conn = DriverManager.getConnection(url, username, password);
            int resultId = Integer.parseInt(id);
            PreparedStatement st = conn.prepareStatement("SELECT id, name, description FROM items WHERE id=?");

            st.setInt(1, resultId);
            ResultSet res = st.executeQuery();
            while (res.next()) {
                if (res.getInt("id") == resultId) {

                    System.out.println("Я был в поиске по ID");

                    System.out.println(String.format("%d %s %s",
                            res.getInt(id),
                            res.getString("name"),
                            res.getString("description"))
                    );
                    break;
                }
            }

            res.close();
            st.close();
        } catch(Exception e) {
            Log.error(e.getMessage(), e);
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

    @Override
    public void close() throws Exception {

    }

}
