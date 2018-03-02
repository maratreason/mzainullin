package ru.mzainullin.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CurrentPointTest {

    // Судя по всему с такими результатом вычислений протестировать нереально :)
    @Test
    public void measureDistanceFromPointOneToPointTwo() {
        CurrentPoint point = new CurrentPoint(0, 1);
        CurrentPoint point2 = new CurrentPoint(2, 6);
        double result = point.measureDistance(point2);
        assertThat(result, is(5.385164807134504));
    }

}
