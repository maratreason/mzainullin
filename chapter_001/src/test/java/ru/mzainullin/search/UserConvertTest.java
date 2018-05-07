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
        list.add(new User(0, "Ivan","Moscow"));

        assertThat(userConvert.process(list).toString(), is("{0=User{id=0, name='Ivan', city='Moscow'}}"));
    }
}