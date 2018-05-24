package ru.mzainullin.iterators;

import java.util.*;

/**
 * @author Marat Zainulline
 * @version 1.0
 * @since 20.05.2018
 */
public class ArrayIter implements Iterator {

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
            this.column = 0;
            this.row++;
        }

        return result;
    }
}

