package ru.mzainullin.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Marat Zainullin.
 * @version 1.0
 * @since 0.1
 */
public class ArrayCharTest {

    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("Hel");
        assertThat(result, is(true));
    }

   /* @Test
    public void whenNotStartWithPrefixThenFalse() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("Hi");
        assertThat(result, is(false));
    }*/

//    @Test
//    public void whenOneWordInSecondWord() {
//        ArrayChar word = new ArrayChar("Hello");
//        boolean result = word.contains("Hello", "ell");
//        assertThat(result, is(true));
//    }

}
