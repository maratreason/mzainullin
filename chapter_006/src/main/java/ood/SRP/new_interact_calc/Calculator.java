package ood.SRP.new_interact_calc;


/**
* Class Calculator для вычисления арифметических операций + - * /
*
* @author mzainullin
* @since 01.03.2018
*/
public class Calculator implements CalcActions {

	/**
	* Сложение.
	* @param first First.
	* @param second Second.
	*/
	@Override
	public double add(double first, double second) {
		return first + second;
	}

	/**
	* Вычитание.
	* @param first первый аргумент.
	* @param second второй аргумент.
	*/
	@Override
	public double subtract(double first, double second) {
		return first - second;
	}

	/**
	* Умножение.
	* @param first первый аргумент.
	* @param second второй аргумент.
	*/
	@Override
	public double multiple(double first, double second) {
		return first * second;
	}

	/**
	* Деление.
	* @param first первый аргумент.
	* @param second второй аргумент.
	*/
	@Override
	public double divide(double first, double second) {
		return first / second;
	}

}