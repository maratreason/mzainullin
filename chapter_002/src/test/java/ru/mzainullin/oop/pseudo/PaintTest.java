package ru.mzainullin.oop.pseudo;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Marat Zainullin
 * @version 1.2
 * @since 18.04.2018
 */
public class PaintTest {

    // получаем ссылку на стандартный вывод в консоль.
    PrintStream stdout = System.out;
    // Создаем буфер для хранения вывода.
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("before");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("after");
    }

    @Test
    public void whenDrawSquare() {
        // выполняем действия пишушие в консоль.
        new Paint().draw(new Square());
        // проверяем результат вычисления
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                        .append("+++++++\n")
                        .append("+     +\n")
                        .append("+     +\n")
                        .append("+++++++\n")
                        .append(System.lineSeparator()).toString()
                )
        );

    }

    @Test
    public void whenDrawTriangle() {
        // выполняем действия пишушие в консоль.
        new Paint().draw(new Triangle());
        // проверяем результат вычисления
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                        .append("   +   \n")
                        .append("  + +  \n")
                        .append(" +   + \n")
                        .append("+ + + +\n")
        .append(System.lineSeparator()).toString()
                )
        );
    }

}
