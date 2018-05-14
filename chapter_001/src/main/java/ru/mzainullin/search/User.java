package ru.mzainullin.search;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 04.05.2018
 */
public class User {
    private int id;
    private String name;
    private String city;

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", city='" + city + '\''
                + '}';
    }
}
