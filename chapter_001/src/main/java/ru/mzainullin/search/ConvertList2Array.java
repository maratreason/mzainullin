package ru.mzainullin.search;

import java.util.List;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 02.05.2018
 */
public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / rows);
        int[][] array = new int[rows][cells];
        int row = 0;
        int cell = 0;
        for (Integer value : list) {
            array[row][cell++] = value;
            if (cell == cells) {
                cell = 0;
                row++;
            }
        }
        return array;
    }
}