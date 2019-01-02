package io;

import io.bytestream.CheckByteStream;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Marat Zainullin
 * version 1.0
 */
public class CheckByteStreamTest {

    private int [] nums = {2, 3};

    @Test
    public void whenIsNumberEven() {
        String data = String.valueOf(nums[0]);
        CheckByteStream check = new CheckByteStream();
//        assertThat(check.isNumber(System.setIn(data.getBytes())), is("Вы ввели"));
    }

    @Test
    public void whenIsNumberOdd() {

    }
}