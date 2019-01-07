package ru.mzainullin.calculator;


/**
* Class Calculator для вычисления арифметических операций + - * /
*
* @author mzainullin
* @since 01.03.2018
*/
public class Calculator {

	private double result;

	/**
	* Add.
	* @param first First.
	* @param second Second.
	*/
	public double add(double first, double second) {
		return first + second;
	}

	/**
	* Вычитание.
	* @param first первый аргумент.
	* @param second второй аргумент.
	*/
	public double subtract(double first, double second) {
		return first - second;
	}

	/**
	* Умножение.
	* @param first первый аргумент.
	* @param second второй аргумент.
	*/
	public double multiple(double first, double second) {
		return first * second;
	}

	/**
	* Деление.
	* @param first первый аргумент.
	* @param second второй аргумент.
	*/
	public double divide(double first, double second) {
		return first / second;
	}	

	/**
	* Метод получения результата вычисления
	 * @return - result.
	*/
	public double getResult() {
		return this.result;
	}

}