package ru.mzainullin.calculator;

/**
* Программя для расчета веса.
*/
public class Fit {

	/**
	* Идеальный вес для мужщины.
	* @param height Рост.
	* @return идеальный вес.
	*/
	double manWeight(double height) {
		final double MAN_WEIGHT = 100;
		return (height - MAN_WEIGHT) * 1.15;
	}

	/**
	* Идеальный вес для женщины.
	* @param height Рост.
	* @return идеальный вес.
	*/
	double womanWeight(double height) {
		final double WOMAN_WEIGHT = 110;
		return (height - WOMAN_WEIGHT) * 1.15;
	}

}