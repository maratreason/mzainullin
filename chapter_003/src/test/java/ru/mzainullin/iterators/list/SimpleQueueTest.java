package ru.mzainullin.iterators.list;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 04.06.2018
 */
public class SimpleQueueTest {

    private SimpleQueue<Object> queue;

    @Before
    public void beforeTest() {
        queue = new SimpleQueue<>();
        SimpleQueue.push(new String("first"));
        list.add(new String("second"));
        list.add(new String("third"));
    }

    @Test
    public void poll() {

    }

    @Test
    public void push() {

    }
}