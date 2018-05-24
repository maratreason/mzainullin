package ru.mzainullin.arrayIterator;

import java.util.Iterator;

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

    @Override
    public boolean hasNext() {
        // it.hasNext() - возвращает true, только если в массиве есть простые числа перед указателем.
        boolean isTrue = false;
        for (int index = 0; index != arr.length; index++) {
            if (arr[index] > 0 && arr[index] % 2 == 0) {
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

    /*
    * boolean b = true;
        for (int P = 1; P <= 'число'; P++) {
            for (int i = 1; i < P; i++)
            {
                if (P % i == 0){
                    b = false;
                }
            System.out.println(P);}
        }


        или так:
        public static boolean checkSimple(int i){
            if (i<=1)
                return false;
            else if (i <=3)
                return true;
            else if (i%2==0 || i %3 ==0)
                return false;
            int n = 5;
            while (n*n <=i){
                if (i % n ==0 || i % (n+2) == 0)
                    return false;
            n=n+6;
        }
        return true;
    }
    *
    *
    *
    *
    *
    * Или так:
    * boolean isPrime=true;

	int n=5;
	for(int i=2;i<n;i++){
         if((n%i)==0){
            isPrime=false;
            continue;
          }
        }
    if(isPrime) System.out.println(n+" Prostoe");
    else System.out.println("NE prostoe");



    так:
    public static boolean isPrime(long n) {
		if (n < 0) return false; // negatives are not primes.
		if (n == 0) return false; // 0 is not a prime
		if (n == 1) return false; // 1 is not a prime
		if (n < 4) return true; // 2 and 3 are primes
		if (n % 2 == 0) return false; // filter out even numbers
		if (n < 9) return true; // we already excluded 4, 6, 8.
		if (n % 3 == 0) return false; // filter out numbers % 3

		// if we can't find divider from 0 to r, then n is prime
		long r = (long) Math.floor(Math.sqrt(n));

		// All primes greater than 3 cab be written in 6k +/- 1
		long f = 5;
		while (f <= r) {
			if (n % f == 0) return false;
			if (n % (f + 2) == 0) return false;
			f += 6;
		}

		return true;
	}




    * */
}
