package ru.mzainullin.loop;

/**
* @author Marat Zainullin
* @version 1.0
* @since 0.1
*/
public class Counter {

	/**
	* Метод должен вычислять сумму четныx чисел в диапазоне от start до finish;
	* @param first
	* @param finish
	* @return Сумма чисел переменной first. От числа first до числа finish.
	*/
	public int add(int start, int finish) {
		int temp = 0;
		for (start = 0; start <= finish; start++) {

			if (start % 2 == 0) {
				temp += start;
			}
		}
		return temp;
	}

}