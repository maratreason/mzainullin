package ru.mzainullin.calculator;

/**
* Программя для расчета веса.
*/
public class Fit {

	private static final double MAN_WEIGHT = 100;
	private static final double WOMAN_WEIGHT = 110;
	private static final double MULT_WEIGHT = 1.15;

	/**
	* Идеальный вес для мужщины.
	* @param height Рост.
	* @return идеальный вес.
	*/
	double manWeight(double height) {
		return (height - MAN_WEIGHT) * MULT_WEIGHT;
	}

	/**
	* Идеальный вес для женщины.
	* @param height Рост.
	* @return идеальный вес.
	*/
	double womanWeight(double height) {
		return (height - WOMAN_WEIGHT) * MULT_WEIGHT;
	}

}