package ru.mzainullin.iterators.generics;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Marat Zainullin
 * @since 26.05.2018
 */
public class StoreTest {

    private SimpleArray it;

    @Before
    public void setUp() {
        it = new SimpleArray(5);
    }

    @Test
    public void whenGenericIsUserAndExpectUserId() {
        SimpleArray<User> array = new SimpleArray<User>(5);
        array.add(new User("0"));
        array.add(new User("18"));
        array.add(new User("23"));

        String result = array.get(1).toString();

        assertThat(result, is("18"));
    }


}
