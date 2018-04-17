package ru.mzainullin.oop.pseudo;

/**
 * @author Marat Zainullin
 * @version 1.1
 * @since 17.04.2018
 */
public class Triangle implements Shape {

    public String draw() {
        StringBuilder triangle = new StringBuilder();
        triangle.append("   +   \n");
        triangle.append("  + +  \n");
        triangle.append(" +   + \n");
        triangle.append("+ + + +\n");
        return triangle.toString();
    }
}
