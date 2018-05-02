package ru.mzainullin.search;

import java.util.Arrays;
import java.util.List;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 02.05.2018
 */
public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        for (int i = 0; i != list.size(); i++) {
            if(!(list.size() % rows == 0)) {
                list.add(0);
                break;
            }
        }
        int cells = list.size();
        int[][] array = new int[rows][cells];
        return array;
    }
}
