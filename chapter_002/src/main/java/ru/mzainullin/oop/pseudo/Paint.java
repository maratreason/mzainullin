package ru.mzainullin.oop.pseudo;

/**
 * @author Marat Zainullin
 * @version 1.1
 * @since 17.04.2018
 */
public class Paint {

    private Shape shape;

    /**
     * Метод для прорисовки фигуры
     * @param shape - фигура
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Triangle());
        paint.draw(new Square());
    }

}
