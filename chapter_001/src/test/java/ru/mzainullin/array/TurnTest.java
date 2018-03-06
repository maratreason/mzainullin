package ru.mzainullin.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author MaratZainullin
 * @version 1.0
 * @since 0.1
 */
public class TurnTest {

    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {

        int[] numbers = {1, 5, 7, 4, 3, 7, 8, 9};
        Turn turn = new Turn();
        int[] result = turn.back(numbers);
        int[] expectArray = {9, 8, 7, 3, 4, 7, 5, 1};
        assertThat(result, is(expectArray));
    }

    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {

        int[] numbers = {1, 5, 7, 4, 3, 7, 8};
        Turn turn = new Turn();
        int[] result = turn.back(numbers);
        int[] expectArray = {8, 7, 3, 4, 7, 5, 1};
        assertThat(result, is(expectArray));

    }

}
