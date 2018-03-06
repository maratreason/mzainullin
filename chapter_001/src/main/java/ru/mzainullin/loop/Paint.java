package ru.mzainullin.loop;

import java.util.function.BiPredicate;

/**
 * @author Marat Zainullin
 * @version 1.1
 * @since 0.1
 */
public class Paint {

    /**
     * Рефакторинг.
     * @param width
     * @param height
     */
    private String loppBy(int height, int width, BiPredicate<Integer, Integer> predict) {
        StringBuilder builder = new StringBuilder();
        for(int row = 0; row != height; row++) {
            for(int col = 0; col != width; col++) {
                if(predict.test(row, col)) {
                    builder.append("^");
                } else {
                    builder.append(" ");
                }
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    /**
     * Метод для прорисовки правой части пирамиды.
     * @param height
     * @return
     */
    public String rightTriangle(int height) {
        return this.loppBy(height, height, (row, col) -> row >= col);
    }

    /**
     * Метод для прорисовки левой части пирамиды.
     * @param height
     * @return
     */
    public String leftTriangle(int height) {
        return this.loppBy(height, height, (row, col) -> row >= height - col - 1);
    }

    /**
     * Метод для прорисовки полной пирамиды.
     * @param height
     * @return
     */
    public String pyramid(int height) {
        return this.loppBy(height, 2 * height - 1,
            (row, col) -> row >= height - col - 1 && row + height - 1 >= col);
    }

}
