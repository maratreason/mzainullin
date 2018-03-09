package ru.mzainullin.array;

import java.util.Arrays;
import org.junit.Test;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

/**
 * @author Marat Zainullin.
 * @version 1.0
 * @since 0.1
 */
public class ArrayDublicateTest {

    @Test
    public void whenArrayHasDuplicatesThenDrop() {

        String[] lang = {"java", "php", "c++", "python", "javascript", "php", "c++"};

        ArrayDublicate dublicate = new ArrayDublicate();
        String[] result = dublicate.remove(lang);
        String[] expect = {"java", "php", "c++", "python", "javascript"};

        assertThat(result, arrayContainingInAnyOrder(expect));
    }
}
