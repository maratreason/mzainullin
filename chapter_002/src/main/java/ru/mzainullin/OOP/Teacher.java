package ru.mzainullin.OOP;

/**
 * @author Marat Zainullin.
 * version 1.0.
 * since 0.1.
 */
public class Teacher extends Profession {

    /**
     * teach method
     * @param student
     */
    public String teach(Student student) {
        return student.getName() +  " учится...";
    }

}
