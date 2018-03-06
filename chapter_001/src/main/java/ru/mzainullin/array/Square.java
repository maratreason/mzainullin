package ru.mzainullin.array;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 0.1
 */
public class Square {

    /**
     * Метод Возведение числа в квадрат и запись в массив.
     * @param bound
     * @return результат умноженный на результат.
     */
    public int[] calculate(int bound) {
        int[] result = new int[bound];

        for(int i = 1; i < bound; i++) {
            result[i] = i * i;
            System.out.println(result[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Square square = new Square();
        square.calculate(7);
    }

}
