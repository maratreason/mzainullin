package ru.mzainullin.loop;

public class Factorial {

	public int temp = 1;

	public int calc(int n) {

		if (n <= 0) {
			return 1;
		}

		for (int i = 1; i <= n; i++) {
			temp *= i;
		}
		return temp;
	}

}