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
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }

    /**
     * Метод сортировки по длине имени
     * @return отсортированный список по длине имени
     */
    public List<User> sortNameLength(List<User> lists) {
        lists.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
            //и в анонимном классе переопределить compare
        });
        return lists;
    }

    /**
     * Метод сортировки по обоим полям,
     * сначала сортировка по имени в лексикографическом порядке,
     * потом по возрасту.
     * @return отсортированный список
     */
    public List<User> sortByAllFields(List<User> lists) {

        lists.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                final int rsl = o1.getName().compareTo(o2.getName());
                return rsl != 0 ? rsl : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return lists;
    }
}

