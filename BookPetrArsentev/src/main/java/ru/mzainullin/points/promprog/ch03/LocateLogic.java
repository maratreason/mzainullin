package ru.mzainullin.points.promprog.ch03;

/**
 * @author Marat Zainullin (maratreason@mail.ru)
 * @version 1.1
 * @since 0.1
 * 1.04.2018
 */
public class LocateLogic {

    public double calculateDistance(Point t1, Point t2) {
        double dx = t1.getX() - t2.getX();
        double dy = t1.getY() - t2.getY();
        return Math.hypot(dx, dy);
    }

}
