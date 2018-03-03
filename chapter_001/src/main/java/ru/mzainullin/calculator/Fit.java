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
		final double MULT_WEIGHT = 1.15;
		return (height - MAN_WEIGHT) * MULT_WEIGHT;
	}

	/**
	* Идеальный вес для женщины.
	* @param height Рост.
	* @return идеальный вес.
	*/
	double womanWeight(double height) {
		final double WOMAN_WEIGHT = 110;
		final double MULT_WEIGHT = 1.15;
		return (height - WOMAN_WEIGHT) * MULT_WEIGHT;
	}

}