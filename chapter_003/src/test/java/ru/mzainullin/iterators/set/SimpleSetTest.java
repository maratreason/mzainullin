package ru.mzainullin.iterators.set;

import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Marat Zainullin
 * @since 06.06.2018
 */
public class SimpleSetTest {

    private SimpleSet<String> set;

    @Test
    public void whenAddElementToSet() {
        set = new SimpleSet<>();
        set.add("first");
        set.add("second");
        set.add("third");
        set.add("fourth");
        set.add("second");

        for (String s : set) {
            System.out.println(s);
        }
        assertThat(set.get(4), is("third"));
    }


}