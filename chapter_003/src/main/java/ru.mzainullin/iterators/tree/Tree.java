package ru.mzainullin.iterators.tree;

import java.util.*;

/**
 * @author Marat Zainullin
 * @since 13.06.2018
 * @param <E> - параметр
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    private Node<E> root;
    private int modCount = 0;

    public Tree(E element) {
        Node<E> node = new Node<>(element);
        this.root = node;
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> foundParent = findBy(parent); // здесь вам нужно реализовать метод findBy
        boolean result = false;
        if (foundParent.isPresent()) {
            foundParent.get().add(new Node<>(child));
            modCount++;
            result = true;
        }
        return result;
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
    public Iterator iterator() {
        Iterator it = new Iterator() {

            @Override
            public boolean hasNext() {
                return root != null;
            }

            @Override
            public Object next() {
                return modCount++;
            }
        };
        return it;
    }
}
