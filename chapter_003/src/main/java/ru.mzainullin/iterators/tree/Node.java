package ru.mzainullin.iterators.tree;

import java.util.*;

/**
* @author Marat Zainullin
* @since 13.06.2018
* @param <E> - параметр
*/
public class Node<E extends Comparable<E>> implements SimpleTree<E> {

    private final List<Node<E>> children = new ArrayList<>();
    private final E value;
    private Node<E> root;
    private Node<E> leftChild;
    private Node<E> rightChild;
    private Node<E> parent;


    public Node(final E value) {
        this.value = value;
    }


    public void add(Node<E> child) {
        if (root == null) {
            root = child;
        } else {
            Node<E> current = root;
            while(true) {
                parent = current;
                if (parent.eqValue(child.value)) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = child;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = child;
                        return;
                    }
                }
            }
        }

    }


    public List<Node<E>> leaves() {
        return this.children;
    }


    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }


    @Override
    public boolean add(E parent, E child) {
        return false;
    }


    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }


    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
