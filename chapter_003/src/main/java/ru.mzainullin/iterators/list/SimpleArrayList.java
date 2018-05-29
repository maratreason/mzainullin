package ru.mzainullin.iterators.list;

import java.util.NoSuchElementException;

/**
 * @author Marat Zainullin.
 * since 27.05.2018.
 * @param <E> - Тип коллекции, устанавливаемый пользователем.
 */
public class SimpleArrayList<E> {

    private int size;
    private Node<E> first;


    /**
     * Метод вставляет в начало списка данные.
     * @param date - данные для вставки.
     */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }


    /**
     * Метод удаления первого элемента в списке.
     * @return - коллекция без удаленного элемента.
     */
    public E delete(int index) {
        Node<E> newLink = this.first;

        this.first = newLink.next;

        if (newLink.next == null)
            this.first = null;
        else
            newLink.next = null;
            newLink = this.first;

                    size--;
        return (E) newLink;
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
        return result.date;
    }


    /**
     * Метод получения размера коллекции.
     * @return - размер коллекции.
     */
    public int getSize() {
        return this.size;
    }


    /**
     * Класс предназначен для хранения данных.
     * @param <E> - тип данных.
     */
    private static class Node<E> {
        E date;
        Node<E> next;

        Node(E date) {
            this.date = date;
        }
    }

}
