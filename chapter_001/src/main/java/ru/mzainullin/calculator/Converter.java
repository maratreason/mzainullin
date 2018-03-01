package ru.mzainullin.calculator;

/**
* Конвертор валюты.
*/
public class Converter {

	/**
	* Конвертитуем рубли в евро.
	* @param value рубли
	* @return Евро.
	*/
	public int rubleToEuro(int value) {
		return value / 70;
	}

	/**
	* Конвертитуем рубли в доллары.
	* @param value рубли
	* @return Доллары.
	*/
	public int rubleToDollar(int value) {
		return value / 60;
	}
}