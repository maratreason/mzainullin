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

        Map<User, Object> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        for (User user : map.keySet()) {
            System.out.println(user.name + ", " + user.children + ", " + user.birthday.getTime());
        }
    }
}