package ru.mzainullin.iterators.set;

/**
 * @author Марат Зайнуллин.
 * @since 07.06.2018.
 * @param <K> - Тип данных - Ключ.
 * @param <V> - Тип данных - Значение.
 */
public class SimpleHashSetContainer<K, V> {

    private final K key;
    private final V value;
    private boolean deleted;

    public SimpleHashSetContainer(K key, V value) {
        this.key = key;
        this.value = value;
        this.deleted = false;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public boolean isDeleted() {
        return deleted;
    }
}
