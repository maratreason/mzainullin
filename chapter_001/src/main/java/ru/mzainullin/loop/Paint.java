package ru.mzainullin.loop;

/**
 * @author Marat Zainullin
 * @version 1.1
 * @since 0.1
 */
public class Paint {

    /**
     * Метод для прорисовки правой части пирамиды.
     * @param height
     * @return
     */
    public String rightTriangle(int height) {

        StringBuilder builder = new StringBuilder();
        int width = height;

        for(int row = 0; row != height; row++) {
            for(int col = 0; col != width; col++) {
                if(row >= col) {
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
     * Метод для прорисовки левой части пирамиды.
     * @param height
     * @return
     */
    public String leftTriangle(int height) {

        StringBuilder builder = new StringBuilder();
        int width = height;

        for(int row = 0; row != height; row++) {
            for(int col = 0; col != width; col++) {
                if(row >= width - col - 1) {
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
     * Метод для прорисовки полной пирамиды.
     * @param height
     * @return
     */
    public String pyramid(int height) {

        StringBuilder builder = new StringBuilder();
        int width = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int col = 0; col != width; col++) {
                if (row >= height - col - 1 && row + height - 1 >= col) {
                    builder.append("^");
                } else {
                    builder.append(" ");
                }
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
