package ru.mzainullin.iterators.generics;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Marat Zainullin
 * @since 24.05.2018
 */
public class SimpleArrayTest {

    private SimpleArray it;

    @Before
    public void setUp() {
        it = new SimpleArray(5);
    }

    @Test
    public void whenGenericIsIntegerAndExpectInteger() {
        SimpleArray<Integer> array = new SimpleArray<Integer>(5);
        array.add(4);
        int result = array.get(0);
        assertThat(result, is(4));
    }


    @Test
    public void whenGenericIsStringAndExpectString() {
        SimpleArray<String> array = new SimpleArray<String>(5);
        array.add("Ivan");
        String result = array.get(0);
        assertThat(result, is("Ivan"));
    }


    @Test
    public void whenSetModelByIndexAndReturnResult() {
        SimpleArray<String> array = new SimpleArray<String>(5);
        array.add("Ivan");
        array.add("Irina");
        String result = array.set(0, "Alex");
        assertThat(result, is("Alex"));
    }


    @Test
    public void whenDeleteModelByIndexAndReturnNewCopyArray() {
        SimpleArray<String> array = new SimpleArray<String>(5);
        array.add("Ivan");
        array.add("Irina");
        array.delete(0);
        String result = array.get(0);
        assertThat(result, is("Irina"));
    }


    @Test
    public void whenIterateArrayAndReturnIterateIndex() {
        Iterator<SimpleArray> newIterator = it.iterator();
        it.add("Ivan");
        it.add("Irina");
        it.add("Igor");
        it.add("Alex");
        it.add("Sveta");
        assertThat(newIterator.hasNext(), Matchers.is(true));
        assertThat(newIterator.next(), Matchers.is("Ivan"));
        assertThat(newIterator.hasNext(), Matchers.is(true));
        assertThat(newIterator.next(), Matchers.is("Irina"));
        assertThat(newIterator.hasNext(), Matchers.is(true));
        assertThat(newIterator.next(), Matchers.is("Igor"));
        assertThat(newIterator.hasNext(), Matchers.is(true));
        assertThat(newIterator.next(), Matchers.is("Alex"));
        assertThat(newIterator.hasNext(), Matchers.is(true));
        assertThat(newIterator.next(), Matchers.is("Sveta"));
        assertThat(newIterator.hasNext(), Matchers.is(false));
        it.iterator().next();
    }

}
