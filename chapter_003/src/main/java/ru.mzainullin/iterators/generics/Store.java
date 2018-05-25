package ru.mzainullin.iterators.generics;

/**
 * @author Marat Zainullin
 * @since 25.05.2018
 * @param <T> - тип ограниченный Base
 */
public interface Store<T extends Base> {

    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}
