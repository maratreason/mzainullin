package ru.mzainullin.iterators.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Marat Zainullin
 * @since 07.06.2018
 */
public class SimpleNodeTest {

    @Test
    public void whenNodeCycle() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;

        assertThat(third.hasCycle(two), is(true));
    }

}