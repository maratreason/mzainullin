package ru.mzainullin.arrayIterator;

import java.util.*;

/**
 * @author Marat Zainulline
 * @version 1.0
 * @since 20.05.2018
 */
public class ArrayIter implements Iterator {

    /*int[][] array;
    int outerCursor;
    int lastArrayLen;
    int totalElems;
    int tracker = 1;
    Queue<Integer> myQueue = new LinkedList<>();

    public ArrayIter(int[][] arr) {
        if (arr.length == 0) {
            throw new NoSuchElementException();
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
    }*/

    private int[][] array; // Массив для хранения элементов.
    private int row; // Индекс строки
    private int column; // Индекс столбца.

    public ArrayIter(int[][] arr) {
        this.array = arr;
    }

    public boolean hasNext() {
        return row != array.length;
    }

    public Object next() {
        if (row >= array.length) {
            throw new NoSuchElementException();
        }

        int result = this.array[this.row][this.column++];

        if (this.column >= this.array[this.row].length) {
           result = this.array[this.row][this.column];
        }
        return result;
    }

}

