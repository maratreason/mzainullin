package ru.mzainullin.iterators.tree;

import ru.mzainullin.iterators.tree.Node.*;

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
     * @return- true / false
     */
    boolean add(E parent, E child);

    /**
     * Найти элемент по значению
     * @param value - значение
     * @return - true / false
     */
    Optional<Node<E>> findBy(E value);
}
