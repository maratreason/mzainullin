package ru.mzainullin.points.promprog.ch03;

/**
 * @author Marat Zainullin (maratreason@mail.ru)
 * @version 1.1
 * @since 0.1
 * 1.04.2018
 */
public class Department {

    {
        System.out.println("logic (1) id=" + this.id);
    }

    static {
        System.out.println("Static logic");
    }

    private int id = 7;

    public Department(int d) {
        id = d;
        System.out.println("Конструктор id=" + id);
    }

    int getId() {return id;}
    {
        id = 10;
        System.out.println("logic (2) id=" + id);
    }

}
