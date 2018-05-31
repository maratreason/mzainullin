package ru.mzainullin.iterators.list;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Marat Zainullin
 * @since 30.05.2018
 */
public class DynamicArrayListTest {
    private DynamicArrayList<Object> list;

    @Before
    public void beforeTest() {
        list = new DynamicArrayList<>();
        list.add(new String("first"));
        list.add(new String("second"));
        list.add(new String("third"));
    }


    @Test
    public void whenGetElement() {
        Object result = list.get(1);
        assertThat(result, is("second"));
    }


    @Test
    public void whenRemoveElement() {
        list.remove(0);
        Object result = list.get(0);
        assertThat(result, is("second"));
    }


    @Test
    public void whenIterateArrayAndReturnIterateIndex() {
        Iterator<Object> newIterator = list.iterator();
        assertThat(newIterator.hasNext(), Matchers.is(true));
        assertThat(newIterator.next(), Matchers.is("first"));
        assertThat(newIterator.hasNext(), Matchers.is(true));
        assertThat(newIterator.next(), Matchers.is("second"));
        assertThat(newIterator.hasNext(), Matchers.is(true));
        assertThat(newIterator.next(), Matchers.is("third"));
        assertThat(newIterator.hasNext(), Matchers.is(false));
        list.iterator().next();
    }
}
