package ru.mzainullin.iterators.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class LinkedListContainerTest {

    private LinkedListContainer<Object> list;

    @Before
    public void beforeTest() {
        list = new LinkedListContainer<>();
        list.add("first");
        list.add("second");
        list.add("third");
    }


    @Test
    public void whenAddNewElementToLinkedListContainer() {
        System.out.println("До добавления нового элемента.");
        for (int i = 0; i != list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        list.add("fourth");

        System.out.println("\nПосле добавления нового элемента.");
        for (int i = 0; i != list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        Object result = list.get(3);
        assertThat(result, is("fourth"));
    }


    @Test
    public void whenGetElementByIndexFromLinkedListContainer() {
        Object result = list.get(1);
        assertThat(result, is("second"));
    }


    @Test
    public void whenRemoveElementByIndexFromLinkedListContainer() {
        LinkedListContainer<Integer> linkedListContainer = new LinkedListContainer<>();
        linkedListContainer.add(1);
        linkedListContainer.add(2);
        linkedListContainer.add(3);
        assertThat(linkedListContainer.remove(), is(1));
    }


    @Test
    public void iterateList() {
        LinkedListContainer<String> linkedListContainer = new LinkedListContainer<>();
        Iterator<String> itr = linkedListContainer.iterator();
        linkedListContainer.add("Alisa");
        linkedListContainer.add("Liza");
        assertThat(itr.next(), is("Alisa"));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("Liza"));
        assertThat(itr.hasNext(), is(false));
    }
}