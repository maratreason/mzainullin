package ru.mzainullin.calculator;

/**
* Конвертор валюты.
*/
public class Converter {

	private static final int EURO = 70;
	private static final int DOLLAR = 60;

	/**
	* Конвертитуем рубли в евро.
	* @param value рубли
	* @return Евро.
	*/
	public int rubleToEuro(int value) {
		
		return value / EURO;
	}

	/**
	* Конвертитуем рубли в доллары.
	* @param value рубли
	* @return Доллары.
	*/
	public int rubleToDollar(int value) {
		
		return value / DOLLAR;
	}
}