package ru.mzainullin.iterators.generics;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

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
    public void whenGenericIsIntegerAndExpectInteger() {
        Object user = new User("0");
        Object role = new Role("0");
        SimpleArray<User> array = new SimpleArray<User>(5);
        array.add(user);
        int result = array.get(0);
        assertThat(result, is(4));
    }


}
