package ru.mzainullin.points.promprog.ch03;

/**
 * @author Marat Zainullin (maratreason@mail.ru)
 * @version 1.1
 * @since 0.1
 * 1.04.2018
 */
public class PointRunner {

    public static void main(String[] args) {
        Point t1 = new Point(5, 10);
        Point t2 = new Point(2, 6);
        System.out.print("Расстояние равно : " + new LocateLogic().calculateDistance(t1, t2));
    }

}
