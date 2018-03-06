package ru.mzainullin.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author MaratZainullin
 * @version 1.0
 * @since 0.1
 */
public class FindLoopTest {

    @Test
    public void whenIndexOfReturnElement() {
        FindLoop loop = new FindLoop();
        int[] numbers = {5, 4, 3, 9, 6, 1};
        int result = loop.indexOf(numbers, 6);

        assertThat(result, is(4));
    }
}
