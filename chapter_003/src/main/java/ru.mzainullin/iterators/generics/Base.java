package ru.mzainullin.iterators.generics;

/**
 * @author Marat Zainullin
 * @since 25.05.2018
 */
public abstract class Base {
    private final String id;
    protected Base(final String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
}