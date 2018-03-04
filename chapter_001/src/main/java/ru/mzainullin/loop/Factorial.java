package ru.mzainullin.loop;

/**
* @author Marat Zainullin
* @version 1.0
* @since 0.1
*/
public class Factorial {

	public int calc(int n) {
		int temp = 1;

		for (int i = 1; i <= n; i++) {
			temp *= i;
		}		

		return temp;
	}

}