package ru.mzainullin.DBStore.model;

/**
 * @author Marat Zainullin
 * @since 25.05.2018
 */
public abstract class Base {

    private final String id;
    private String name;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}