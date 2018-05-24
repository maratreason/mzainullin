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
     * @param n - входящий параметр
     * @return - простое число: true / false.
     */
    public boolean primes(int n) {
        boolean isPrime = true;
        if (n < 2) {
            isPrime =  false;
        } else if (n == 2) {
            isPrime = true;
        } else if (n % 2 == 0) {
            isPrime = false;
        }
        // n > 1 is odd
        int d = 3;
        while(d * d <= n) {
            if (n % d == 0) {
                isPrime = false;
            }
            d += 2;
        }
        return isPrime;
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
