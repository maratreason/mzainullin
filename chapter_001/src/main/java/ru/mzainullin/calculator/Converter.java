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
		final int UERO_RATE = 70;
		return value / UERO_RATE;
	}

	/**
	* Конвертитуем рубли в доллары.
	* @param value рубли
	* @return Доллары.
	*/
	public int rubleToDollar(int value) {
		final int UERO_RATE = 60;
		return value / UERO_RATE;
	}
}