package ru.mzainullin.iterators.tree;

import java.util.*;

/**
* @author Marat Zainullin
* @since 13.06.2018
* @param <E> - параметр
*/
public class Node<E extends Comparable<E>> {

    private final List<Node<E>> children = new ArrayList<>();
    private final E value;

    public Node(final E value) {
        this.value = value;
    }

    public void add(Node<E> child) {
        this.children.add(child);
    }

    public List<Node<E>> leaves() {
        return this.children;
    }

    public E getValue() {
        return this.value;
    }

    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }

}
