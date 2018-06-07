package ru.mzainullin.iterators.list;

/**
 * @author Marat Zainullin
 * @since 06.06.2018
 * @param <E>
 */
public interface SimpleContainer<E> extends Iterable<E> {
    void add(E e);
    E get(int index);
}