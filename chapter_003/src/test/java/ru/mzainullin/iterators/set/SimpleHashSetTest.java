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

    SimpleHashSet<Integer> hashSet = new SimpleHashSet<>();

    @Before
    public void add() {
        hashSet.add(3);
        hashSet.add(5);
        hashSet.add(6);
    }


    @Test
    public void whenAddElementToSimpleHashSet() {
        hashSet.add(17);
        assertThat(hashSet.contains(17), is(true));
    }

    @Test
    public void whenCheckContainsElementInSimpleHashSet() {
        assertThat(hashSet.contains(6), is(true));
        assertThat(hashSet.contains(7), is(false));
    }

    @Test
    public void whenRemoveElementFromSimpleHashSet() {
        System.out.println("size: " + hashSet.size());
        hashSet.remove(6);
        assertThat(hashSet.size(), is(2));
        System.out.println("size: " + hashSet.size());
    }
}