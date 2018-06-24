package ru.mzainullin.iterators.tree;

import java.util.Optional;

/**
 * @author Marat Zainullin
 * @since 13.06.2018
 * @param <E> - параметр
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     * @param parent parent.
     * @param child child.
     * @return
     */
    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);
}
