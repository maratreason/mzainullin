package ru.mzainullin.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 0.1
 */
public class SquareTest {

    @Test
    public void whenPutFiveAndReturnTwentyFive() {
        Square square = new Square();
        int[] result = square.calculate(9);
        int[] expecttArray = new int[] {0, 1, 4, 9, 16, 25, 36, 49, 64};

        assertThat(result, is(expecttArray));
    }

}
