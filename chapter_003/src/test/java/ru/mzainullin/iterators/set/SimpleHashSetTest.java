package ru.mzainullin.iterators.set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Марат Зайнуллин.
 * @since 07.06.2018.
 */
public class SimpleHashSetTest {

    @Before
    public void add() {
        SimpleHashSet<Integer> hashSet = new SimpleHashSet<>();
        hashSet.add(3);
        hashSet.add(5);
        hashSet.add(6);
    }



    @Test
    public void whenAddElementToSimpleHashSet() {

    }

    @Test
    public void whenCheckContainsElementInSimpleHashSet() {

    }

    @Test
    public void whenRemoveElementFromSimpleHashSet() {

    }
}