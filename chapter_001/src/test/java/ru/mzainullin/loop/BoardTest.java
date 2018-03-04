package ru.mzainullin.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BoardTest {

	@Test
	public void when3x3() {
		Board board = new Board();
		String str = board.paint(3, 3);
		String line = System.lineSeparator();
		assertThat(str, is(
			String.format("X X%s X %sX X%s", line, line, line)
			)
		);
	}

	@Test
	public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {
		Board board = new Board();
		String str = board.paint(5, 4);
		String line = System.lineSeparator();
		assertThat(str, is(
			String.format(" X  X  X%s  X  X %s X  X  X%s  X  X %s", line, line, line, line))
		);
	}
}