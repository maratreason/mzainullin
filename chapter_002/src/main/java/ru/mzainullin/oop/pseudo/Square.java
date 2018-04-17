package ru.mzainullin.oop.pseudo;

/**
 * @author Marat Zainullin
 * @version 1.1
 * @since 17.04.2018
 */
public class Square implements Shape {

    /**
     * Метод для прорисовки квадрата
     * @return квадрат
     */
    public String draw() {
        StringBuilder square = new StringBuilder();
        square.append("+++++++\n");
        square.append("+     +\n");
        square.append("+     +\n");
        square.append("+++++++\n");
        return square.toString();
    }
}
