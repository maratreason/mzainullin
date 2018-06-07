package ru.mzainullin.iterators.set;

import org.junit.Before;
import org.junit.Test;
import ru.mzainullin.iterators.list.DynamicArrayList;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Marat Zainullin
 * @since 06.06.2018
 */
public class SimpleSetTest {

//    SimpleSet<String> set = new SimpleSet<>();

    private DynamicArrayList<String> list;

    @Before
    public void beforeTest() {
        list = new DynamicArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");

        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void whenAddElementToSet() {
        list.add("second");

        System.out.println("\nПосле добавления копии");
        for (String s : list) {
            System.out.println(s);
        }

        assertThat(list.get(4), is("third"));
    }


}