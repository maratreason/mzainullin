package ru.mzainullin.oop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Marat Zainullin.
 * Test-class
 * version 1.0.
 * since 0.1.
 */
public class ProfessionTest {

    Doctor doctor = new Doctor();
    Student student = new Student();
    Patient patient = new Patient();
    Engineer engineer = new Engineer();
    Teacher teacher = new Teacher();
    House house = new House();

    @Test
    public void whenDoctorOpenUpPatient() {
        String result = doctor.repair(patient);
        assertThat(result, is("Рабинович вылечен..."));
    }

    @Test
    public void whenTeacherTeachedAStudent() {
        String result = teacher.teach(student);
        assertThat(result, is("Шурик учится..."));
    }

    @Test
    public void whenBuildHouse() {
        String result = engineer.build(house);
        assertThat(result, is("ПентХаус построен..."));
    }

}

