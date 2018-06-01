package ru.mzainullin.iterators.list;

import ru.mzainullin.iterators.generics.SimpleArray;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Marat Zainullin
 * @since 31.05.2018
 */
public class LinkedListContainer<E> implements Iterable<E> {

    private SimpleArrayList<E> simpleLinkedList;
    private int nextIndex = 0;

    public void add(E value){
        simpleLinkedList = new SimpleArrayList<>();
        this.simpleLinkedList.add(value);
        nextIndex++;
    }

    public int size() {
        return this.nextIndex;
    }

    public E get(int index){
        E result = null;
        for (int i = 0; i != simpleLinkedList.getSize(); i++) {
            if (simpleLinkedList.get(i).equals(index) && simpleLinkedList.get(i) != null) {
                result = this.simpleLinkedList.get(i);
            }
        }
        return result;
    }

    public E remove(int index) {
        E result = null;
        for (int i = 0; i != simpleLinkedList.getSize(); i++) {
            if (simpleLinkedList.get(i).equals(index)) {
                this.simpleLinkedList = null;
                nextIndex--;
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < simpleLinkedList.getSize();
            }

            @Override
            public E next() {
                if (hasNext())
                    if (this.currentIndex >= simpleLinkedList.getSize()) {
                        throw new NoSuchElementException();
                    }
                return simpleLinkedList.get(currentIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}
