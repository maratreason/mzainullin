package io.bytestream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Marat Zainullin
 * version 1.0
 */
public class CheckByteStream {

    public boolean isNumber(InputStream in){
        boolean checkNumber = false;

        int num;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            num = Integer.parseInt(reader.readLine());

            if (num % 2 == 0) {
                System.out.println("Вы ввели четное число");
                checkNumber = true;
            } else {
                System.out.println("Вы ввели нечетное число");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return checkNumber;
    }

    public static void main(String[] args) {
        CheckByteStream check = new CheckByteStream();
        check.isNumber(System.in);
    }

}
