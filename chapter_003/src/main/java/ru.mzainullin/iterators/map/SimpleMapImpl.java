package ru.mzainullin.iterators.map;

/**
 * @author Marat Zainullin
 * @since 10.06.2018
 */
public interface SimpleMapImpl<K, V> extends Iterable<V> {
    boolean insert(K key, V value);
    V get(K key);
    boolean delete(K key);
}
