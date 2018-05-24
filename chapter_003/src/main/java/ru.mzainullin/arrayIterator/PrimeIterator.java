package ru.mzainullin.arrayIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Marat Zainullin
 * @since 23.05.2018
 */
public class PrimeIterator implements Iterator {

    private int[] arr;
    private int position = 0;

    public PrimeIterator(final int[] numbers) {
        this.arr = numbers;
    }


    /**
     * Метод вычисления простых чисел.
     * @param number - входящий параметр
     * @return - простое число: true / false.
     */
    public boolean primes(int number) {
        boolean result = false;
        for (int i = 2; i <= number; i++) {
            if (i > Math.sqrt(number)) {
                result = true;
                break;
            }
            if (number % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }


    @Override
    public boolean hasNext() {
        // it.hasNext() - возвращает true, только если в массиве есть простые числа перед указателем.
        boolean isTrue = false;
        for (int index = position; index != arr.length; index++) {
            if (primes(arr[index])) {
                isTrue = true;
                break;
            } else {
                this.position++;
            }
        }
        return isTrue;
    }


    @Override
    public Object next() {
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
