package ru.mzainullin.points.promprog.ch01.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HomeWorkOne {

    public static void init() {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader buff = new BufferedReader(is);

        try {
            System.out.println("Введите ваше имя:");
            String name = buff.readLine();
            System.out.println("Привет, " + name + ". Как ваши дела?");
        }catch(IOException e) {
            System.err.print("Ошибка вывода " + e);
        }
    }

    public static void main(String[] args) {
        HomeWorkOne.init();
    }

}
