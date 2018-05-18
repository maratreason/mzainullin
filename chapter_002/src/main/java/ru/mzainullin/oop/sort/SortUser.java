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
        AgeCompare ageSort = new AgeCompare();
        for (User user : lists) {
            ageSort.compareTo(user);
        }
        return lists;
    }

    public class AgeCompare implements Comparable<User> {
        User user;
        @Override
        public int compareTo(User o) {
            return user.getAge().compare(o.getAge());
        }
    }
}

