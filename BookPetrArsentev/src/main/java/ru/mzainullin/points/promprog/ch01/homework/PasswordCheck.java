package ru.mzainullin.points.promprog.ch01.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasswordCheck {
    public static void init() {
        InputStreamReader is1 = new InputStreamReader(System.in);
        BufferedReader buff1 = new BufferedReader(is1);

        InputStreamReader is2 = new InputStreamReader(System.in);
        BufferedReader buff2 = new BufferedReader(is2);

        String pass = "root";
        try {
            System.out.println("Введите пароль:");
            String first = buff1.readLine();
            String second = buff2.readLine();

            int num1 = Integer.parseInt(first);
            int num2 = Integer.parseInt(second);

            int result =  sum(num1, num2);
            int resultMult =  mult(num1, num2);

            if(result != 0) {
                System.out.println("сумма чисел равна: " + result);
                System.out.println("Произведение чисел равно: " + resultMult);
            } else {
                System.out.println("Пожалуйста введите числа");
            }

        }catch(IOException e) {
            System.err.print("Ошибка вывода " + e);
        }
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int mult(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        PasswordCheck.init();

    }
}
