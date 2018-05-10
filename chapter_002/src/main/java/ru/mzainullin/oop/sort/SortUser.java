package ru.mzainullin.oop.sort;

import java.util.*;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 07.05.2018
 */
public class SortUser {

    /**
     * Метод сортировки пользователей по возрасту
     * @return отсортированный список.
     */
    public Set<User> sort (List<User> lists, TreeSet<User> newSet) {
        for (int i = 0; i < lists.size(); i++) {
            newSet.add(lists.get(i));
        }
        return newSet;
    }

}

