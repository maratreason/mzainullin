package ru.mzainullin.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

	@Test
	public void whenAddOnePlusOneTheTwo() {
		Calculator calc = new Calculator();
		calc.add(5D, 5D);
		double result = calc.getResult();
		double expected = 10D;
		assertThat(result, is(expected));
	}

	@Test
	public void whenSubtractOneMinusOneTheTwo() {
		Calculator calc = new Calculator();
		calc.subtract(5D, 2D);
		double result = calc.getResult();
		double expected = 3D;
		assertThat(result, is(expected));
	}

	@Test
	public void whenMultipleTwoMultTwoTheFour() {
		Calculator calc = new Calculator();
		calc.multiple(5D, 7D);
		double result = calc.getResult();
		double expected = 35D;
		assertThat(result, is(expected));
	}

	@Test
	public void whenDivideFourMultTwoTheTwo() {
		Calculator calc = new Calculator();
		calc.divide(15D, 3D);
		double result = calc.getResult();
		double expected = 5D;
		assertThat(result, is(expected));
	}

}