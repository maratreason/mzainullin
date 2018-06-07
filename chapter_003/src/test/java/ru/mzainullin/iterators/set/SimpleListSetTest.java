package ru.mzainullin.iterators.set;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Marat Zainullin
 * @since 07.06.2018
 */
public class SimpleListSetTest {

    SimpleListSet<Integer> simpleSet = new SimpleListSet<>();

    @Test
    public void whenAddElementsToLinkedSet() {
        simpleSet.add(0);
        simpleSet.add(4);
        simpleSet.add(6);
        simpleSet.add(4);
        assertThat(simpleSet.get(0), is(0));
        assertThat(simpleSet.get(1), is(4));
        assertThat(simpleSet.get(2), is(6));

        assertThat(simpleSet.size(), is(3));
    }

}