package ru.mzainullin.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Marat Zainullin
 * @since 21.05.2018
 */
public class EvenIterator implements Iterator {

    private int position = 0;
    private int[] arr;

    public EvenIterator(final int[] numbers) {
        this.arr = numbers;
    }

    @Override
    public boolean hasNext() {
        boolean isTrue = false;
        for (int index = position; index != arr.length; index++) {
            if (arr[position] % 2 == 0) {
                isTrue = true;
                break;
            }
            this.position++;
        }
        return isTrue;
    }

    @Override
    public Integer next() {
        int arrPos = 0;
        hasNext();
        if (this.position >= arr.length) {
            throw new NoSuchElementException();
        } else {
            arrPos = arr[position++];
        }
        return arrPos;
    }
}
