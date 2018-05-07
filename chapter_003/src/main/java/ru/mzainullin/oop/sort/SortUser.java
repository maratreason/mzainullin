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
    public Set<User> sort (List<User> lists) {
        Set<User> newSet = new TreeSet<>();
        User user = new User();

        for (int index = 0; index != lists.size(); index++) {
            user.compareTo(lists.get(index));
            newSet.add(user);
        }
        return newSet;
    }
}

