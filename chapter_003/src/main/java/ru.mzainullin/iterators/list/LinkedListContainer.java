package ru.mzainullin.iterators.list;

import ru.mzainullin.iterators.generics.SimpleArray;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Marat Zainullin
 * @since 31.05.2018
 */
public class LinkedListContainer<E> implements Iterable<E> {

    private int size;
    private Node<E> first;
    private Node<E> last;

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

    public int size() {
        return this.size;
    }

    /**
     * Метод вставляет в начало списка данные.
     * @param element - данные для вставки.
     */
    public void add(E element){
        final Node<E> lastNode = this.last;
        final Node<E> newNode = new Node<>(lastNode, element, null);
        this.last = newNode;
        if (lastNode != null) {
            lastNode.next = newNode;
        } else {
            this.first = newNode;
        }
        size++;
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


    /**
     * Метод удаления первого элемента в списке.
     * @return - коллекция без удаленного элемента.
     */
    public E remove() {
        E result = this.first.item;
        if (size > 1) {
            this.first.next.prev = null;
            this.first = this.first.next;
        } else {
            this.first = null;
            this.last = null;
        }
        size--;
        return result;
    }


    @Override
    public Iterator<E> iterator() {
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

/*    Необходимо создать динамический контейнер с методами:

        1) add(E value);
        2) E get(int index);
        3) реализовать интерфейс Iterable<E>.

        Внутри контейнер должен базироваться на связанном списке(Node<E> node).
        Использовать стандартные коллекции JDK (ArrayList, LinkedList и т.д.) запрещено.
        Контейнер должен быть динамическим, т.е. увеличиваться по мере добавления элементов.

        Итератор должен реализовывать fail-fast поведение, т.е. если с момента создания итератора коллекция подверглась
        структурному изменению, итератор должен кидать ConcurrentModificationException.
        Это достигается через введение счетчика изменений - modCount. Каждая операция,
        которая структурно модифицирует коллекцию должна инкрементировать этот счетчик.
        В свою очередь итератор запоминает значение этого счетчика на момент своего создания (expectedModCount),
        а затем на каждой итерации сравнивает сохраненное значение, с текущим значением поля modCount,
        если они отличаются, то генерируется исключение.
*/