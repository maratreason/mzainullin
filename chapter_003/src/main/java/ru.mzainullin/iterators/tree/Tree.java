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

    /**
     * Метод должен проверять количество дочерних элементов в дереве.
     * Если их <= 2 - то дерево бинарное.
     * Метод должен циклически пройти по всем элементам дерева.
     * Для этого можно использовать итератор.
     *
     * @return - true / false
     */
    @Override
    public boolean isBinary() {
        E elem = root.getValue();
        Tree<E> tree = new Tree<E>(elem);
        boolean isTrue = false;
        int counter = 0;

        if (tree.iterator().hasNext()) {
            tree.iterator().next();
            counter++;
        }

        if (counter <= 2) {
            isTrue = true;
        } else {
            isTrue = false;
        }

        return isTrue;
    }


    @Override
    public Iterator<E> iterator() {

        Iterator<E> it = new Iterator<E>() {
            int count = 0;
            private Node<E> next;

            @Override
            public boolean hasNext() {
                return next != null && count <= 2;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("All nodes have been visited!");
                } else {
                    count++;
                }

                return root.getValue();
            }
        };
        return it;
    }
}
