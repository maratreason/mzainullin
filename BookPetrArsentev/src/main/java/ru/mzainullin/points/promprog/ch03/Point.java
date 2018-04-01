package ru.mzainullin.points.promprog.ch03;

/**
 * @author Marat Zainullin (maratreason@mail.ru)
 * @version 1.1
 * @since 0.1
 * 1.04.2018
 */
public class Point {
    
    private final double x;
    private final double y;

    public Point(final double xx, final double yy) {
        super();
        x = xx;
        y = yy;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
