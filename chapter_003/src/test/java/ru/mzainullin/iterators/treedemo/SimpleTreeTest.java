package ru.mzainullin.iterators.treedemo;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleTreeTest {

    @Test
    public void when6ElFindLastThen6() {
        SimpleTree<Integer> tree = new SimpleTree<>();
        tree.add(1);
        tree.add(13);
        tree.add(-21);
        tree.add(6);

        for (Integer i : tree) {
            System.out.println(i);
        }
//        assertThat(tree.find(6), is(true));

    }

    @Test
    @Ignore
    public void when6ElFindNotExitThenOptionEmpty() {
        /*SimpleTree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        assertThat(tree.find(7).isPresent(), is(false));*/
    }
}