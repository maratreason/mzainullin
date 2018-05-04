package ru.mzainullin.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 04.05.2018
 */
public class UserConvertTest {

    @Test
    public void whenConvertListToHaspMap() {
        UserConvert userConvert = new UserConvert();
        List<User> list = new ArrayList<>();
        list.add(new User(1, "Ivan","Moscow"));

        HashMap<Integer, User> users = new HashMap<Integer, User>();

        for (User user : list) {
            users.put(user.getId(), user);
        }

        for (Integer user1 : users.keySet()) {
            System.out.println(String.format("%s : %s", user1, users.get(user1)));
        }

        assertThat(userConvert.process(list).toString(), is("{0=User{id=1, name='Ivan', city='Moscow'}}"));
    }
}
