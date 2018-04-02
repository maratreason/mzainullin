package ru.mzainullin.OOP.models;

/**
 * @author Marat Zainullin (maratreason@mail.ru)
 * @version 1.0
 * @since 18.03.2018
 */
public class Task extends Item {
    public Task(String name, String desc) {
        this.name = name;
        this.description = desc;
    }
}
