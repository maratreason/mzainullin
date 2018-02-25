package ru.mzainullin;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
* 
* @author Marat Zainullin (maratreason@mail.ru)
* @version $Id$
* @since 0.1
*/

public class CalculateTest {

	/**
	* Test echo.
	*/
	@Test
	public void whenTakeNameThenTreeEchoPlusName() {
		String input = "Okey Everybody";
		String expect = "Echo, echo, echo: Okey Everybody";
		Calculate calc = new Calculate();
		String result = calc.echo(input); 
		assertThat(result, is(expect));
	}

}