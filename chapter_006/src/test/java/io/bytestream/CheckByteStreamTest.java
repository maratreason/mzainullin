package io.bytestream;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

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
        assertThat(check.isNumber(System.setIn(data.getBytes())), is("Вы ввели"));
    }

    @Test
    public void whenIsNumberOdd() {

    }
}