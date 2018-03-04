package ru.mzainullin.loop;

import org.junit.Test;
import java.util.StringJoiner;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Marat Zainullin
 * @version 1.1 Test
 * @since 0.1
 */
public class PaintTest {

    @Test
    public void whenPyramidForRight() {
        Paint paint = new Paint();
        String rst = paint.rightTriangle(4);
        System.out.println(rst);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                        .add("^   ")
                        .add("^^  ")
                        .add("^^^ ")
                        .add("^^^^")
                        .toString()
                ));
    }

    @Test
    public void whenPyramidForLeft() {
        Paint paint = new Paint();
        String lst = paint.leftTriangle(4);
        System.out.println(lst);
        assertThat(lst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("   ^")
                                .add("  ^^")
                                .add(" ^^^")
                                .add("^^^^")
                                .toString()
                )
        );
    }

    @Test
    public void whenAllPyramidDraw() {
        Paint paint = new Paint();
        String pyram = paint.pyramid(4);
        System.out.println(pyram);
        assertThat(pyram,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("   ^   ")
                                .add("  ^^^  ")
                                .add(" ^^^^^ ")
                                .add("^^^^^^^")
                                .toString()
                )
        );
    }

}
