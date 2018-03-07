package ru.mzainullin.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Marat Zainullin.
 * @version 1.0
 * @since 0.1
 */
public class BubbleSortTest {

    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        int[] numbers = {154, 22, 1, 4, 29, 3, 7, 0, 2, 5};
        int[] expectNumbers = {0, 1, 2, 3, 4, 5, 7, 22, 29, 154};

        BubbleSort bubble = new BubbleSort();
        int[] exNums = bubble.sort(numbers);


        assertThat(exNums, is(expectNumbers));
    }

}
