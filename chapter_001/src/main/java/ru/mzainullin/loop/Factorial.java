package ru.mzainullin.loop;

public class Factorial {

	public int calc(int n) {

		int temp = 1;

		for (int i = 1; i <= n; i++) {
			temp *= i;
		}
		
		return temp;
	}

}