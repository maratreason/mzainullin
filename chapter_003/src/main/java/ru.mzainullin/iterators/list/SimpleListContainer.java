package ru.mzainullin.iterators.list;

/**
 * @author Marat Zainullin
 * @since 06.06.2018
 * @param <E>
 */
public interface SimpleListContainer<E> extends Iterable<E> {
    E poll();
    void push(E value);
}
