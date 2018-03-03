package ru.mzainullin.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {

	@Test
	public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
		Factorial myFact = new Factorial();
		int result = myFact.calc(4);
		assertThat(result, is(24));
	}

	@Test
	public void whenCalculateFactorialForZeroThenOne() {
		Factorial myFactZero = new Factorial();
		int resultZero = myFactZero.calc(0);
		assertThat(resultZero, is(1));
	}

}