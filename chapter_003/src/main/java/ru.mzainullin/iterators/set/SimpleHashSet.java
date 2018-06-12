package ru.mzainullin.iterators.set;

import ru.mzainullin.iterators.map.SimpleMapImpl;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author Марат Зайнуллин.
 * @since 07.06.2018.
 * @param <E> - Тип данных - Ключ.
 */
public class SimpleHashSet<E> {

    private static final int DEFAULT_SIZE = 10;
    private Object[] array;
    private int size = 0;

    public SimpleHashSet() {
        this.array = new Object[DEFAULT_SIZE];
    }


    boolean add (E element) {
        boolean result = false;
        if (size == array.length) {
            resize(size);
        }
        else if (!contains(element)) {
            array[hash(element)] = element;
            result = true;
            size++;
        }
        return result;
    }


    public void resize(int newSize) {
        newSize = this.array.length * 2;
        Object[] newArray = new Object[newSize];
        for (Object arr : this.array) {
            newArray[Math.abs(arr.hashCode() % newArray.length)] = arr;
        }
        this.array = newArray;
    }


    public boolean remove (E element) {
        boolean result = false;
        if (contains(element)) {
            array[hash(element)] = null;
            result = true;
            size--;
        }
        return result;
    }


    public boolean contains (E element) {
        boolean result = false;
        if (array[hash(element)] != null && array[hash(element)].equals(element)) {
            result = true;
        }
        return result;
    }


    public int size() {
        return size;
    }


    private int hash(E key) {
        return Math.abs(key.hashCode() % this.array.length);
    }
}