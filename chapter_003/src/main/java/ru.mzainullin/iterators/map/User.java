package ru.mzainullin.iterators.map;

import java.util.*;

/**
 * @author Marat Zainullin
 * @since 08.06.2018
 */
public class User {

    public String name;
    public int children;
    public Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}
/*
Создать модель User и три поля String name, int children, Calendar birthday,
 */