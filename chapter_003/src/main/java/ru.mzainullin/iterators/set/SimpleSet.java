package ru.mzainullin.iterators.set;

import ru.mzainullin.iterators.list.DynamicArrayList;

import java.util.Iterator;

/**
 * @author Marat Zainullin
 * @since 07.06.2018
 */
public class SimpleSet<E> implements Iterable<E> {

    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;

    DynamicArrayList<E> container = new DynamicArrayList<E>();

    /**
     * Метод добавления элемента
     * @param element - новый элемент.
     * @return - true / false.
     */
    public boolean add(E element) {
        for (E check : this.container) {
            if (check.equals(element)) {
                return false;
            }
        }
        this.container.add(element);
        return true;
    }

    /**
     * Вспомогательный метод для масштабирования.
     * @param newLength - новая копия массива после изменений.
     */
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }

    /**
     * Метод возвращает элемент списка по индексу.
     * @param index - индекс искомого элемента.
     * @return - возвращает индекс найденного элемента.
     */
    public E get(int index) {
        return (E) this.array[index];
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < CUT_RATE && array[currentIndex] != null;
            }

            @Override
            public E next() {
                return (E) array[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}

