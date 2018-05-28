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

        User userOne = array.get(0);
        User userTwo = array.get(1);
        User userThree = array.get(2);

        assertThat(userOne.getId(), is("0"));
        assertThat(userTwo.getId(), is("18"));
        assertThat(userThree.getId(), is("23"));
    }

    @Test
    public void whenGenericIsRoleAndExpectRoleId() {
        SimpleArray<Role> array = new SimpleArray<Role>(4);
        array.add(new Role("1"));
        array.add(new Role("15"));
        array.add(new Role("10"));

        Role roleOne = array.get(0);
        Role roleTwo = array.get(1);
        Role roleThree = array.get(2);

        assertThat(roleOne.getId(), is("1"));
        assertThat(roleTwo.getId(), is("15"));
        assertThat(roleThree.getId(), is("10"));
    }
}
