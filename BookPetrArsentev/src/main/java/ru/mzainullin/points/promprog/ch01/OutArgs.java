package ru.mzainullin.points.promprog.ch01;

public class OutArgs {
    public static void main(String[] args) {
        for(String str : args) {
            System.out.printf("Арг-> %s%n", str);
        }
    }
}
