package ru.mzainullin.iterators.generics;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Marat Zainullin
 * @since 24.05.2018
 */
public class SimpleArray<T> implements Iterable<T> {

    private Object[] objects;
    private int index = 0;

    /**
     * Конструктор, инициализирующий массив объектов
     * @param size - размер массива.
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * Метод добавления объекта
     * @param model - объект
     */
    public void add(T model) {
        this.objects[index++] = model;
    }

    /**
     * Метод замены текущего объекта на новый
     * @param index - позиция объекта в массиве
     * @param model - новый объект
     * @return - вставленный объект
     */
    public T set(int index, T model) {
        for (int i = 0; i != objects.length; i++) {
            if(index == i) {
                this.objects[i] = model;
            }
        }
        return model;
    }

    /**
     * Метод удаления объекта по индексу
     * @param index - позиция удаляемого объекта
     */
    public void delete(int index) {
        if (index >= 0 && index < objects.length) {
            Object[] tmp = new Object[objects.length - 1];
            System.arraycopy(objects, 0, tmp, 0, index);
            System.arraycopy(objects, index + 1, tmp, index, objects.length - index - 1);
            objects = tmp;
        }
    }

    /**
     * Метод получения объекта из массива
     * @param position - позиция объекта в массиве
     * @return - размер массива определяется параметром position
     */
    public T get(int position) {
        return (T) this.objects[position];
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private Object[] newObject = objects;
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < newObject.length && newObject[currentIndex] != null;
            }

            @Override
            public T next() {

                for (int i = 0; i != newObject.length; i++) {
                    if (this.currentIndex >= newObject.length || hasNext() == false) {
                        throw new NoSuchElementException();
                    } else {
                        currentIndex++;
                        break;
                    }
                }
                return (T) newObject[currentIndex++];
            }


            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}
