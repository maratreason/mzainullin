package ru.mzainullin.arrayIterator;

import java.util.*;

/**
 * @author Marat Zainulline
 * @version 1.0
 * @since 20.05.2018
 */
public class ArrayIter implements Iterator {

    int[][] array;
    int outerCursor;
    int lastArrayLen;
    int totalElems;
    int tracker = 1;
    Queue<Integer> myQueue = new LinkedList<>();

    public ArrayIter(int[][] arr) {
        if (arr.length == 0) {
            throw new NoSuchElementException();
//            arr = new int[][] {};
        }
        this.array = arr;
        this.outerCursor = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                totalElems += 1;
            }
        }
        for (int i = 0; i < array[0].length; i++) {
            myQueue.add(array[0][i]);
        }
    }

    public boolean hasNext() {
        return array.length > outerCursor && totalElems >= tracker;
    }

    public Object next() {
        if (myQueue.isEmpty()) {
            outerCursor++;
            for (int i = 0; i < array[outerCursor].length; i++) {
                myQueue.add(array[outerCursor][i]);
            }
            if (!myQueue.isEmpty()) {
                tracker++;
                return myQueue.remove();
            }
        } else {
            tracker++;
            return myQueue.remove();
        }
        return -1;
    }
}

