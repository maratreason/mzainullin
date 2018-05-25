package ru.mzainullin.iterators.generics;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Marat Zainullin
 * @since 24.05.2018
 */
public class SimpleArrayTest {

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
        SimpleArray<String> array = new SimpleArray<String>(5);
        array.add("Ivan");
        array.add("Irina");
        array.add("Igor");
        String result = "";

        for (String name : array) {
            result = array.iterator().next();
            System.out.println(result);
        }

        assertThat(result, is("Irina"));

        while (array.iterator().hasNext()) {
            System.out.println("Список имен:");
            System.out.println(array.iterator().next());
            break;
        }
    }



}
