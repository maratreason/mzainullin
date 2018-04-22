package ru.mzainullin.oop.start;

/**
 * @author Marat Zainullin
 * @version 1.1
 * @since 20.04.2018
 */
public interface UserAction {

    int key();
    void execute(Input input, Tracker tracker);
    String info();

}
