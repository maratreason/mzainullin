package ru.mzainullin.iterators.map;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author Marat Zainullin
 * @since 09.06.2018
 */
public class UserTest {

    @Test
    public void mapUser() {
        User first = new User("petr", 3, new GregorianCalendar(1982,6,9));
        User second = new User("petr", 3, new GregorianCalendar(1982,6,9));

        Set<User> set = new HashSet<>();
        set.add(first);
        set.add(second);
        for (User user : set) {
            System.out.println(user.name + ", " + user.children + ", " + user.birthday.getTime());
        }
    }
}