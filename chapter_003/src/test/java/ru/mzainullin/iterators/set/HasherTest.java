package ru.mzainullin.iterators.set;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class HasherTest {

    Hasher<Integer, String> hash = new Hasher<>(10000);

    @Before
    public void initialize() {
        hash.put(1, "first name");
        hash.put(2, "second name");
        hash.put(4, "fourth name");
    }

    @Test
    public void put() {
        hash.put(3, "third name");
        assertThat(hash.get(3), is("third name"));
    }

    @Test
    public void remove() {
        hash.remove(1);
        Integer result = null;
        assertThat(hash.get(1), is(result));
    }

    @Test
    public void get() {
    }

    @Test
    public void contains() {
        assertThat(hash.contains(4), is(true));
    }

    @Test
    public void getIndexForKey() {
    }

    @Test
    public void printTable() {
    }
}