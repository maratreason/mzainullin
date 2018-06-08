package ru.mzainullin.iterators.set;

import ru.mzainullin.iterators.list.DynamicArrayList;

import java.util.Iterator;

/**
 * @author Marat Zainullin
 * @since 07.06.2018
 */
public class SimpleSet<E> implements Iterable<E> {

    private DynamicArrayList<E> container = new DynamicArrayList<E>();

    public boolean add(E element) {
        for (E check : this.container) {
            if (check.equals(element)) {
                return false;
            }
        }
        this.container.add(element);
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return  this.container.iterator();
    }
}