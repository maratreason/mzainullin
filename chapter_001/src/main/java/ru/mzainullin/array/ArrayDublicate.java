package ru.mzainullin.array;

import java.util.Arrays;

/**
 * @author Marat Zainullin.
 * @version 1.0
 * @since 0.1
 */
public class ArrayDublicate {


//    String[] lang = {"java", "php", "c++", "python", "javascript", "php", "c++"};

    /**
     * Метод должен убрать все дубликаты строк из массива.
     * @param array
     * @return массив без дубликатов.
     */
    public String[] remove(String[] array) {
        //Для обрезания массива надо использовать Arrays.copyOf метод;
        int temp = array.length;

        for(int i = 0; i < temp; i++) {
            for(int j = i + 1; j < temp; j++) {
                if(array[i].equals(array[j])) {
                    array[j] = array[temp - 1];
                    temp--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, temp);
    }
}
