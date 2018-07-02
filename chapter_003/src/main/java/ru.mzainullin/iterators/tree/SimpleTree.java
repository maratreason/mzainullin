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
     * @return - true / false
     */
    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);

    /**
     * Метод должен проверять количество дочерних элементов в дереве.
     * Если их <= 2 - то дерево бинарное.
     * Метод должен циклически пройти по всем элементам дерева.
     * Для этого можно использовать итератор.
     *
     * @return - true / false
     */
    boolean isBinary();
}
