package ru.mzainullin.max;

/**
* Class Max
* @author Marat Zainullin
* @version 1.0
* @since 0.1
*/
public class Max {

	/**
	* Метод для вычисления большего числа из двух введенных.
	* @param first = первое число
	* @param second = второе число
    * @param third = третье число
	* @return Большее из трех.
	*/
	public int max(int first, int second, int third) {
		return Math.max(Math.max(first, second), third);
	}

}