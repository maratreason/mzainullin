package ru.mzainullin.OOP;

/**
 * @author Marat Zainullin.
 * Class Doctor.
 * version 1.0.
 * since 0.1.
 */
public class Doctor extends Profession {

    String profession = "Доктор";

    /**
     * repair method
     * @param patient
     */
    public String repair(Patient patient) {
        return patient.getName() + " вылечен...";
    }

}
