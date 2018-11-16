package ru.mzainullin.DBStore.service;

import org.apache.commons.dbcp2.BasicDataSource;
import ru.mzainullin.DBStore.model.Store;
import ru.mzainullin.DBStore.model.User;
import ru.mzainullin.DBStore.sql.SQLConnect;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DBStore implements Store<User> {

    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static DBStore INSTANCE = new DBStore();
    List<User> users = new LinkedList<>();

    public DBStore() {
        SOURCE.setUrl("jdbc:postgresql://localhost:5432/DBStore");
        SOURCE.setUsername("postgres");
        SOURCE.setPassword("1111");
        SOURCE.setMinIdle(1);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
    }

    public static DBStore getInstance() {
        return INSTANCE;
    }


    /**
     * Метод добавления пользователя.
     *
     * @param model - модель для добавления
     * @return - новый пользователь.
     */
    @Override
    public User add(User model) {
        String query = "INSERT INTO users (id, name) VALUES (?, ?)";

        try (Connection connection = SOURCE.getConnection();
             PreparedStatement st = connection.prepareStatement(query);
        ) {
            st.setInt(1, Integer.parseInt(model.getId()));
            st.setString(2, model.getName());
            st.executeUpdate();
            this.users.add(model);
            System.out.println("Данные записаны.");
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }


    /**
     * Метод обновления данных.
     *
     * @param id - id модели для замены
     * @param model - новая модель.
     */
    @Override
    public void update(String id, User model) {
        String query = "UPDATE users SET name=? WHERE id=?";

        try (Connection connection = SOURCE.getConnection();
             PreparedStatement st = connection.prepareStatement(query);
        ) {
            st.setInt(2, Integer.parseInt(model.getId()));
            st.setString(1, model.getName());
            st.executeUpdate();
            this.users.set(Integer.parseInt(id), model);
            System.out.println("Данные обновлены.");
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Метод удаления модели.
     *
     * @param id - id удаляемой модели
     * @return - удаленная модель.
     */
    @Override
    public String delete(String id) {
        String query = "DELETE FROM users WHERE id = ?; ";

        try (Connection connection = SOURCE.getConnection();
             PreparedStatement st = connection.prepareStatement(query);
        ) {
            st.setInt(1, Integer.parseInt(id));
            st.executeUpdate();
            this.users.remove(Integer.parseInt(id));
            System.out.println("Данные удалены.");
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }


    /**
     * Выборка всех данных из БД
     * @return list моделей.
     */
    @Override
    public List<User> findAll() {

        this.users.clear();

        String query = "SELECT * FROM users;";

        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement();
        ) {
            ResultSet result = st.executeQuery(query);

            while (result.next()) {
                this.users.add(
                        new User(
                                String.valueOf(result.getInt("id")), result.getString("name")));
            }

            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


    /**
     * Поиск модели по id.
     *
     * @param id - id объекта
     * @return искомая модель.
     */
    @Override
    public String findById(String id) {

        this.users.clear();

        String query = "SELECT * FROM users WHERE id=id;";

        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement();
        ) {
            ResultSet result = st.executeQuery(query);

            while (result.next()) {
                if (result.getInt("id") == Integer.parseInt(id)) {
                    System.out.println("id: " + result.getInt("id")
                            + " name: " + result.getString("name"));
                    this.users.add(new User(String.valueOf(result.getInt("id")), result.getString("name")));
                    break;
                }
            }

            System.out.println("Метод findById().");
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public List<User> getList() {
        return this.users;
    }

    @Override
    public int getSize() {
        return this.users.size();
    }


    public Connection getSQLConnect() {
        return new SQLConnect().getConnectSQL();
    }

    public static void main(String[] args) {
        DBStore dbStore = getInstance();
//        dbStore.add(new User("21", "Nikolay"));

//        dbStore.update("19", new User("19", "Venedikt"));
//        dbStore.delete("22");
//        dbStore.findAll();
//        dbStore.findById("15");
    }

}
