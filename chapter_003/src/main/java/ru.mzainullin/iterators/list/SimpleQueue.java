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

    public SimpleQueue() {
        first = new Node(null, null, last);
        last = new Node(first, null, null);
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

    public void push(E value) {
        final Node<E> lastNode = this.last;
        final Node<E> firstNode = new Node<>(lastNode, value, null);
        this.last = firstNode;
        if (lastNode != null) {
            lastNode.next = firstNode;
        } else {
            this.first = firstNode;
        }
        size++;
    }

    public E poll() {
        final Node<E> result = first.next;

    }


    @Override
    public Iterator iterator() {
        return null;
    }
}

/*
    Используя контейнер на базе связанного списка создать контейнер Stack и Queue.

public class SimpleStack<T> {
    public <T> poll()

    public void push(T value);
}

public class SimpleQueue<T> {
    public <T> poll()

    public void push(T value);
}

    метод poll - должен возвращать значение и удалять его из коллекции. При реализации очереди и стека можете использовать коллекции, которые вы реализовывали в предыдущих заданиях.

        Описание Queue - очередь. Описывается FIFO - first input first output.

        То есть, первый зашел и первый вышел. Например.

        push(1);
        push(2);
        push(3);

        poll() - 1
        poll() - 2
        poll() - 3

        Описание Stack - стек. Описывается LIFO - last input first output.

        То есть, последний зашел и первый вышел. Например.

        push(1);
        push(2);
        push(3);

        poll() - 3
        poll() - 2
        poll() - 1*/
