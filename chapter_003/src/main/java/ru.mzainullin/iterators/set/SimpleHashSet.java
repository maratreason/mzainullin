package ru.mzainullin.iterators.set;

import ru.mzainullin.iterators.list.DynamicArrayList;

import java.util.Set;

/**
 * @author Марат Зайнуллин.
 * @since 07.06.2018.
 * @param <K> - Тип данных - Ключ.
 */
public class SimpleHashSet<K> {

    SimpleSet<K> container = new SimpleSet<K>();

    /**
     * Метод добавления элемента в коллекцию.
     * @param e - добавленный элемент.
     * @return - true / false.
     */
    boolean add (K e) {
        return this.container.add(e);
    }


    /**
     * Метод проверяющий существования элемента в коллекции.
     * @param e - проверяемый элемент.
     * @return - true / false.
     */
    boolean contains (K e) {
        boolean isTrue = false;
        for (K check : this.container) {
            if (check.equals(e)) {
                isTrue =  true;
            }
        }
        return isTrue;
    }


    /**
     * Метод удаления элемента из коллекции.
     * @param e - удаляемый элемент.
     * @return - true / false.
     */
    boolean remove (K e) {
        boolean isTrue = false;
        for (K check : this.container) {
            if (check.equals(e)) {
                isTrue =  true;
            }
        }
        return isTrue;
    }

}


/*
3. Реализовать коллекцию типа Set на базе хэш-таблицы [#998]

        Напишите свою реализацию Set на базе хэш-таблицы. Реализуйте следующие методы:
        1) boolean add (E e)
        2) boolean contains (E e)
        3) boolean remove (E e)

        Ваша хэш-таблица должна базироваться на массиве. Не используйте стандартные коллекции JDK.

        Принципы организации хэш-таблиц вы сможете узнать из следующих источников:
        1) Wikipedia - хеш-таблица
        2) Core Java - К.Хорстманн
        3) Алгоритмы. Построение и анализ. - Т.Кормен и др.
        4) Алгоритмы и структуры данных. - Н. Вирт
        5) Структуры данных и алгоритмы Java - Роберт Лафоре. Стр. 487.

        Разрешение коллизий реализовывать не надо.
        Предусмотрите возможность роста хэш-таблицы при нехватке места для нового элемента. */
