package ru.mzainullin.iterators.set;


import ru.mzainullin.iterators.list.LinkedListContainer;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Marat Zainullin
 * @since 07.06.2018
 */
public class SimpleListSet<E> implements Iterable<E> {

    LinkedListContainer<E> list = new LinkedListContainer<>();

    /**
     * Класс предназначен для хранения данных.
     * @param <E> - тип данных.
     */
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;
        Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.item = element;
            this.next = next;
        }
    }


    /**
     * Метод вставляет в начало списка данные.
     * @param element - данные для вставки.
     */
    public boolean add(E element) {
        for (E check : this.list) {
            if (check.equals(element)) {
                return false;
            }
        }
        list.add(element);
        return true;
    }


    /**
     * Метод для получения элемента по индексу в коллекции.
     * @param index - искомый индекс.
     * @return - данные под нужным индексом.
     */
    public E get(int index) {
        return list.get(index);
    }

    /**
     * Метод показывающий размер списка.
     * @return - размер списка.
     */
    public int size() {
        return list.size();
    }


    @Override
    public Iterator<E> iterator() {
        return  this.list.iterator();
    }
}
