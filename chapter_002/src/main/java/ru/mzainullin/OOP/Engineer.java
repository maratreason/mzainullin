package ru.mzainullin.OOP;

/**
 * @author Marat Zainullin.
 * version 1.0.
 * since 0.1.
 */
public class Engineer extends Profession {

    /**
     * build house method
     * @param house
     */
    public String build(House house) {
        return house.getName() + " построен...";
    }
}
