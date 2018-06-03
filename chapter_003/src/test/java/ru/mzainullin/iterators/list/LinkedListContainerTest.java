package ru.mzainullin.iterators.list;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class LinkedListContainerTest {

    private SimpleArrayList<Object> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
    }


    @Test
    public void whenAddNewElementToLinkedListContainer() {
        System.out.println("До добавления нового элемента.");
        for (int i = 0; i != list.getSize(); i++) {
            System.out.print(list.get(i) + " ");
        }

        list.add("fourth");

        System.out.println("\nПосле добавления нового элемента.");
        for (int i = 0; i != list.getSize(); i++) {
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
        System.out.println("До удаления элемента.");
        for (int i = 0; i != list.getSize(); i++) {
            System.out.print(list.get(i) + " ");
        }

        LinkedListContainer linkedListContainer = new LinkedListContainer();

//        linkedListContainer.remove(1);

        System.out.println("\nПосле удаления элемента.");
        for (int i = 0; i != list.getSize(); i++) {
            System.out.print(list.get(i) + " ");
        }

        Object result = list.get(1);
        assertThat(result, is("third"));
    }


    /*@Test
    public void iterateList() {
        Iterator<Object> newIterator = list.iterator();
        assertThat(newIterator.hasNext(), Matchers.is(true));
        assertThat(newIterator.next(), Matchers.is("first"));
        assertThat(newIterator.hasNext(), Matchers.is(true));
        assertThat(newIterator.next(), Matchers.is("second"));
        assertThat(newIterator.hasNext(), Matchers.is(true));
        assertThat(newIterator.next(), Matchers.is("third"));
        assertThat(newIterator.hasNext(), Matchers.is(false));
        list.iterator().next();
    }*/
}