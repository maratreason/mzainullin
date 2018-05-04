package ru.mzainullin.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();

        for (int[] arr : array) {
            for (int s : arr) {
                list.add(s);
            }
        }

        return list;
    }
}
