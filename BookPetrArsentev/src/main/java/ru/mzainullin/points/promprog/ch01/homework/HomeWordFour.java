package ru.mzainullin.points.promprog.ch01.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HomeWordFour {
    public static void init(){
        InputStreamReader is1 = new InputStreamReader(System.in);
        BufferedReader buff1 = new BufferedReader(is1);

        InputStreamReader is2 = new InputStreamReader(System.in);
        BufferedReader buff2 = new BufferedReader(is2);

        int[] arr = new int[3];

        try {
            System.out.println("Введите числа:");

            String first = buff1.readLine();
            String second = buff2.readLine();

            int num1 = Integer.parseInt(first);
            int num2 = Integer.parseInt(second);

            arr[0] = num1;
            arr[1] = num2;

            for(int array : arr) {
                System.out.println(array);
            }

        }catch(IOException e) {
            System.err.print("Ошибка вывода " + e);
        }
    }

    public static void main(String[] args) {
        init();

        int[] arr2 = {17, 24, 3, 18, 1, 5, 9, 4, 7};
        for(int i = 0; i < arr2.length; i++) {
            if(arr2[i] % 2 == 0) {
                System.out.println("Четные" + arr2[i]);
            } else if(arr2[i] % 2 != 0) {
                System.out.println("Нечетные" + arr2[i]);
            }
        }
        System.out.println("----------------");
        int maxIndex = 0;

        for(int i = 0; i != arr2.length; i++) {
            if(arr2[maxIndex] < arr2[i]) {
                maxIndex = i;
            }
        }
        System.out.println("Самое большое число " + arr2[maxIndex]);
        System.out.println("----------------");

        for(int i = 0; i != arr2.length; i++) {
            if(arr2[i] % 3 == 0 || arr2[i] % 9 == 0) {
                System.out.println("Эти числа делятся на 3 или на 9: " + arr2[i]);
            }
        }
        System.out.println("----------------");
        for(int i = 0; i != arr2.length; i++) {
            if(arr2[i] % 5 == 0 || arr2[i] % 7 == 0) {
                System.out.println("Эти числа делятся на 5 или на 7: " + arr2[i]);
            }
        }
    }

}
