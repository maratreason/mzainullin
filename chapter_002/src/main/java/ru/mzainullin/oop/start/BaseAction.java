package ru.mzainullin.oop.start;

/**
 * @author Marat Zainullin (maratreason@mail.ru)
 * @version 1.2
 * @since 27.04.2018
 */
public abstract class BaseAction implements UserAction {

    private final int key;
    private final String name;

    public BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    public int key() {
        return this.key;
    }

    public String info() {
        return String.format("%s : %s", this.key, this.name);
    }
}
