package ru.mzainullin.points.promprog.ch01;

import java.io.IOException;

public class ReadCharRunner {
    public static void main(String[] args) {
        int x;
        try {
            x = System.in.read();
            char c = (char) x;
            System.out.println("Код символа: " + c + " =" + x);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
