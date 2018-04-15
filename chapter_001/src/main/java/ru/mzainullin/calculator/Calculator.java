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
	* Сложение.
	* @param first первый аргумент.
	* @param second второй аргумент.
	*/
	public void add(double first, double second) {
		this.result = first + second;
	}

	/**
	* Вычитание.
	* @param first первый аргумент.
	* @param second второй аргумент.
	*/
	public void subtract(double first, double second) {
		this.result = first - second;
	}

	/**
	* Умножение.
	* @param first первый аргумент.
	* @param second второй аргумент.
	*/
	public void multiple(double first, double second) {
		this.result = first * second;
	}

	/**
	* Деление.
	* @param first первый аргумент.
	* @param second второй аргумент.
	*/
	public void divide(double first, double second) {
		this.result = first / second;
	}	

	/**
	* Метод получения результата вычисления
	 * @return - result.
	*/
	public double getResult() {
		return this.result;
	}

}