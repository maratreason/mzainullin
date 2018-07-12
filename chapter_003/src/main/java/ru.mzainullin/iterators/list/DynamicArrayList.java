package ru.mzainullin.iterators.list;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Marat Zainullin
 * @since 30.05.2018
 */
@ThreadSafe
public class DynamicArrayList<E> implements Iterable<E> {

    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;

    @GuardedBy("this")
    private Object[] array = new Object[INIT_SIZE];

    private int pointer = 0;


    /**
     * Метод добавляет новый элемент в список.
     * При достижении размера внутреннего
     * массива происходит его увеличение в два раза.
     * @param item - элемент, которых хотим добавить.
     */
    public synchronized void add(E item) {
        if(pointer == array.length-1)
            resize(array.length*2);
        array[pointer++] = item;
    }


    /**
     * Метод возвращает элемент списка по индексу.
     * @param index - индекс искомого элемента.
     * @return - возвращает индекс найденного элемента.
     */
    public synchronized E get(int index) {
        return (E) array[index];
    }


    /**
     * Метод удаления элемента по индексу.
     * Все элементы справа от удаляемого
     * перемещаются на шаг налево. Если после удаления элемента количество
     * элементов стало в CUT_RATE раз меньше чем размер внутреннего массива,
     * то внутренний массив уменьшается в два раза, для экономии занимаемого
     * места.
     * @param index - индекс удаляемого элемента.
     */
    public synchronized void remove(int index) {
        for (int i = index; i<pointer; i++)
            array[i] = array[i+1];
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length/2);
    }


    /**
     * Метод возвращает количество элементов в списке.
     * @return - количество элементов.
     */
    public synchronized int size() {
        return pointer;
    }


    /**
     * Вспомогательный метод для масштабирования.
     * @param newLength - новая копия массива после изменений.
     */
    private synchronized void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
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