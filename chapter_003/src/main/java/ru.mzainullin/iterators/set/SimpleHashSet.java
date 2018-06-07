package ru.mzainullin.iterators.set;

import ru.mzainullin.iterators.list.DynamicArrayList;

/**
 * @author Марат Зайнуллин.
 * @since 07.06.2018.
 * @param <K> - Тип данных - Ключ.
 */
public class SimpleHashSet<K> {

    DynamicArrayList<K> container = new DynamicArrayList<K>();


    /**
     * Метод добавления элемента в коллекцию.
     * @param e - добавленный элемент.
     * @return - true / false.
     */
    boolean add (K e) {
        for (K check : this.container) {
            if (check.equals(e)) {
                return false;
            }
        }
        this.container.add(e);
        return true;
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
        for (int i = 0; i != container.size(); i++) {
            if (container.get(i).equals(e)) {
                container.remove(i);
                isTrue = true;
            }
        }
        return isTrue;
    }

}
