package ru.mzainullin.DBStore.model;

/**
 * @author Marat Zainullin
 * @since 25.05.2018
 */
public class User extends Base {
    private String id;
    private String name;

    public User(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return super.getId();
    }
}