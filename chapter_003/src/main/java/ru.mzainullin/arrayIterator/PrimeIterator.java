package ru.mzainullin.arrayIterator;

import java.util.Iterator;

/**
 * @author Marat Zainullin
 * @since 23.05.2018
 */
public class PrimeIterator implements Iterator {

    private int[] arr;
    private int position = 0;

    public PrimeIterator() {}

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
        for (int index = 0; index != arr.length; index++) {
            if (arr[index] > 0 && primes(arr[index]) == true) {
                this.position++;
                isTrue = true;
                break;
            } else {
                isTrue = false;
            }
        }
        return isTrue;
    }


    @Override
    public Object next() {
        // it.next() - возвращают только простые числа. В этом примере - это 3, 5 и 7.
        int arrPos = 0;
        if (arr.length > this.position) {
            arrPos = this.position++;
        }
        return arrPos;
    }

}
