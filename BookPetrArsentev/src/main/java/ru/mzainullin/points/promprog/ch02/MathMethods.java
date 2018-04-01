package ru.mzainullin.points.promprog.ch02;

public class MathMethods {
    public static void main(String[] args) {
        final int MAX_VALUE = 10;
        double d;

        d = Math.random() * MAX_VALUE;

        System.out.println("d=" + d);
        System.out.println("Округление до целого = " + Math.round(d));
        System.out.println("Ближайшее целое, " + "<= исходного числа = " + Math.floor(d));
        System.out.println("Ближайшее целое, " + ">= исходного числа = " + Math.ceil(d));
        System.out.println("Ближайшее целое значение к числу = " + Math.rint(d));
    }
}
