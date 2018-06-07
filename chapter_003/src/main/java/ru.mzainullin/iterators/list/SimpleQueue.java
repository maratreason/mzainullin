package ru.mzainullin.iterators.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 04.06.2018
 */
public class SimpleQueue<E> implements SimpleListContainer<E> {

    private int size = 0;
    private Node<E> first;
    private Node<E> last;


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


    /**
     * Метод для вставки данных.
     * @param value - объект.
     */
    public void push(E value) {
        final Node<E> lastNode = this.last;
        final Node<E> newNode = new Node<>(lastNode, value, null);
        this.last = newNode;
        if (lastNode != null) {
            lastNode.next = newNode;
        } else {
            this.first = newNode;
        }
        size++;
    }

    /**
     * Метод для получения первого в очереди элемента.
     * @return первый элемент.
     */
    public E poll() {
        final Node<E> firstNode = this.first;
        size--;
        return firstNode.item;
    }

    /**
     * Метод для получения элемента по индексу в коллекции.
     * @param index - искомый индекс.
     * @return - данные под нужным индексом.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.item;
    }



    @Override
    public Iterator iterator() {
        Iterator<E> it = new Iterator<E>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size && last != null;
            }

            @Override
            public E next() {
                currentIndex++;
                Node<E> nextNode = first;

                if (nextNode != null && currentIndex > 1) {
                    nextNode = nextNode.next;
                }

                if (nextNode == null) {
                    throw new NoSuchElementException();
                }
                return nextNode.item;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}
