package ru.mzainullin.arrayIterator;

import java.util.Iterator;

/**
 * @author Marat Zainulline
 * @version 1.0
 * @since 20.05.2018
 */
public class ArrayIter implements Iterator {

    private final int[][] values;
    private int index = 0;

    public ArrayIter(final int[][] newArray) {
        this.values = newArray;
    }

    @Override
    public boolean hasNext() {
        return values.length > index;
    }

    @Override
    public Object next() {
        for (int i = 0; i != values.length; i++) {
            if (i == values.length) {
                i = values[i].length;
                index++;
                int j = 0;
                while (j != values.length) {
                    index++;
                }
            }
        }
        return values[index];
    }
}
