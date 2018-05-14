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
    public Set<User> sort(List<User> lists, TreeSet<User> newSet) {
        for (int i = 0; i < lists.size(); i++) {
            newSet.add(lists.get(i));
        }
        return newSet;
    }

    /**
     * Метод сортировки по длине имени
     * @return отсортированный список по длине имени
     */
    public List<User> sortNameLength(List<User> lists) {
        for (int index = 0; index != lists.size(); index++) {
            Collections.sort(lists);
        }
        return lists;
    }

    /**
     * Метод сортировки по обоим полям,
     * сначала сортировка по имени в лексикографическом порядке,
     * потом по возрасту.
     * @return отсортированный список
     */
    public List<User> sortByAllFields(List<User> lists) {
        for (int index = 0; index != lists.size(); index++) {
            lists.sort(
                    Comparator.comparing(User::getName).thenComparing(User::getAge)
            );
        }
        return lists;
    }
}

