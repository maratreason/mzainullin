package ru.mzainullin.iterators.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 04.06.2018
 */
public class SimpleQueue<E> implements Iterable<E> {

    private int size = 0;
    private Node<E> first;
    private Node<E> last;
    private int count = 0;

    public SimpleQueue() {
        first = new Node(null, null, last);
        last = new Node(first, null, null);
    }

    public E poll() {
        final Node<E> result = first.next;
        return (result.item == null) ? null : helpForPoll(result);
    }

    public void push(E value) {

    }


    private class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }




    // метод извлекает иэлемент из головы очереди и возвращает его
    // удаляет этот элемент или возвращает нул если очередь пустая

    private E helpForPoll(Node<E> value) {
        final E element = value.item;
        first = new Node<>(null, null, first.next.next);
        value.prev = null;
        value.item = null;
        value.next = null;
        size--;
        return element;
    }

    // метод вставляет элемент в конец очереди согласно логике
    public boolean offer(E value) {
        size++;
        return true;
    }

    @Override
    public boolean add(Object value) {
        size++;
        return true;
    }

    @Override
    public E get(int index) {
        Node<E> temp = first.next;
        for (int i = 0; i < index; i++) {
            temp = getNextElement(temp);
        }
        return temp.item;
    }

    private Node<E> getNextElement(Node<E> value) {
        return value.next;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                if (count == size) {
                    throw new NoSuchElementException();
                }
                return get(count++);
            }
        };
    }
}
