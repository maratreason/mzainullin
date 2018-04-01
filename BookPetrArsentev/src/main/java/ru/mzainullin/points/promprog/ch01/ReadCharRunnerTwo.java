package ru.mzainullin.points.promprog.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Остап - Привет, Остап.

public class ReadCharRunnerTwo {
    public static void main(String[] args) {
        /* байтовый поток ввода System.in передается конструктору потока
        чтения при создании объекта класса InputStreamReader */
        InputStreamReader is = new InputStreamReader(System.in);

        /* производится буферизация данных, исключающая необходимость
        обращения к источнику данных при выполнении операции чтения */
        BufferedReader bis = new BufferedReader(is);

        try {
            System.out.println("Введите ваше имя и нажмите <Enter>:");
            /* чтение строки из буфера; метод readLine() требует обработки
            возможной ошибки при вводе из консоли в блоке try */
            String name = bis.readLine();
            System.out.println("Привет, " + name);
        }catch(IOException e) {
            System.err.print("Ошибка ввода" + e);
        }

    }
}
