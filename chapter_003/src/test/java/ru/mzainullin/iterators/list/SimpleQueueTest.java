package ru.mzainullin.iterators.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 04.06.2018
 */
public class SimpleQueueTest {

    private SimpleQueue<String> queue;
    private SimpleStack<String> stack;

    @Before
    public void beforeTest() {
        queue = new SimpleQueue<>();
        queue.push("first");
        queue.push("second");
        queue.push("third");

        stack = new SimpleStack<>();
        stack.push("first");
        stack.push("second");
        stack.push("third");
    }

    @Test
    public void whenPollElementToQueue() {
        assertThat(queue.poll(), is("first"));
    }

    @Test
    public void whenPollElementToStack() {
        assertThat(stack.poll(), is("third"));
    }

    @Test
    public void whenPushElement() {
        queue.push("nextObject");
        assertThat(queue.get(3), is("nextObject"));
    }
}
