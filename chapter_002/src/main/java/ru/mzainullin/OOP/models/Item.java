package ru.mzainullin.oop.models;

/**
 * @author Marat Zainullin (maratreason@mail.ru)
 * @version 1.0
 * @since 18.03.2018
 */
public class Item {

    private String id;
    public String name;
    public String description;
    public long create;

    public Item() {
        this.name = "test name";
        this.description = "desc";
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public long getCreate() {
        return create;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
