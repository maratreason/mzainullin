package ru.mzainullin.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test class.
* @author Marat Zainullin
* @version 1.0
* @since 0.1
*/
public class MaxTest {

	@Test
	public void whenFirstLessSecond() {
		Max maxim = new Max();
		int result = maxim.max(1, 2);
		assertThat(result, is(2));
	}

}

