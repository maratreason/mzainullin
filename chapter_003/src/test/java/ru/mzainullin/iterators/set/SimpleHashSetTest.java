package ru.mzainullin.iterators.set;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Марат Зайнуллин.
 * @since 07.06.2018.
 */
public class SimpleHashSetTest {

    List<Integer> list = new LinkedList<>();

    @Before
    public void add() {
        list.add(3);
        list.add(5);
        list.add(6);
    }


    @Test
    public void whenAddElementToSimpleHashSet() {
        list.add(17);
        assertThat(list.contains(17), is(true));
    }

    @Test
    public void whenCheckContainsElementInSimpleHashSet() {
        assertThat(list.contains(6), is(true));
        assertThat(list.contains(7), is(false));
    }

    @Test
    public void whenRemoveElementFromSimpleHashSet() {
        System.out.println("size: " + list.size());
        list.remove(6);
        assertThat(list.size(), is(2));
        System.out.println("size: " + list.size());
    }
}