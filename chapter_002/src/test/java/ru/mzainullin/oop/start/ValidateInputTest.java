package ru.mzainullin.oop.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Marat Zainullin.
 * Test-class ValidateInput
 * version 1.0.
 * since 26.04.2018
 */
public class ValidateInputTest {

    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        input.ask("select:", new int[] {1});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Пожалуйста введите корректные данные...%n")
                )
        );
    }

}
