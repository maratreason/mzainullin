package ru.mzainullin.condition;

/**
 * Class Point.
 * @author Marat Zainullin (maratreason@mail.ru)
 * @version 1.1
 * @since 0.1
 *
 * */
public class CurrentPoint {

    private int x;
    private int y;

    public CurrentPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double measureDistance(CurrentPoint point) {
        return Math.sqrt(
                Math.pow(this.x - point.x, 2) + Math.pow(this.y - point.y, 2)
        );
    }

    public static void main(String[] args) {
        CurrentPoint a = new CurrentPoint(0, 1);
        CurrentPoint b = new CurrentPoint(2, 6);

        double result =  a.measureDistance(b);
        System.out.println("Растояние между точками a и b: " + result);
    }
}
