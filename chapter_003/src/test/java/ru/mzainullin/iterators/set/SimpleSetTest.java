package ru.mzainullin.iterators.set;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import ru.mzainullin.iterators.list.DynamicArrayList;


import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Marat Zainullin
 * @since 06.06.2018
 */
public class SimpleSetTest {

    private SimpleSet<Integer> simpleSet;
    private Iterator<Integer> itr;

    @Before
    public void beforeTest() {
        simpleSet = new SimpleSet<>();
        itr = simpleSet.iterator();
    }


    @Test
    public void whenAddOneThenTrue() {
        assertThat(simpleSet.add(1), Matchers.is(true));
    }


    @Test
    public void whenAddOneOneTwoThenOneTwo() {
        simpleSet.add(1);
        assertThat(simpleSet.add(1), Matchers.is(false));
        simpleSet.add(2);
        assertThat(itr.next(), Matchers.is(1));
        assertThat(itr.next(), Matchers.is(2));
    }


    @Test
    public void whenAddOneTwoThenOneTwoTrueFalse() {
        simpleSet.add(1);
        simpleSet.add(2);
        assertThat(itr.next(), Matchers.is(1));
        assertThat(itr.hasNext(), Matchers.is(true));
        assertThat(itr.next(), Matchers.is(2));
        assertThat(itr.hasNext(), Matchers.is(false));
    }
}