package ru.mzainullin.iterators.map;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {

    SimpleHashMap<Integer, String> simpleMap = new SimpleHashMap<>();

    @Before
    public void add() {
        simpleMap.insert(1, "alex");
        simpleMap.insert(2, "petr");
        simpleMap.insert(3, "marat");
    }

    @Test
    public void whenInsertDataToCollection() {
        simpleMap.insert(4, "steve");
        assertThat(simpleMap.get(4), is("steve"));
    }

    @Test
    public void whenGetDataFromCollection() {
        assertThat(simpleMap.get(1), is("alex"));
        assertThat(simpleMap.get(2), is("petr"));
        assertThat(simpleMap.get(3), is("marat"));
    }

    @Test
    public void whenDeleteDataFromCollection() {
        simpleMap.delete(3);
        String isNULL = null;
        assertThat(simpleMap.get(1), is("alex"));
        assertThat(simpleMap.get(2), is("petr"));
        assertThat(simpleMap.get(3), is(isNULL));
    }

    @Test
    public void whenIterateDataInCollection() {
        Iterator<String> it = simpleMap.iterator();
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is("alex"));
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is("petr"));
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is("marat"));
        assertThat(it.hasNext(), Matchers.is(false));
        it.next();
    }
}