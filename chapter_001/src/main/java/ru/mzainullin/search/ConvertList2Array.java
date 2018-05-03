package ru.mzainullin.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 02.05.2018
 */
public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {

        Integer newArray[] = new Integer [list.size()] ;
        newArray = list.toArray(newArray);
        int cells = rows;
        for (int arr : newArray) {
            if (arr <= rows) {
                cells = arr;
            }
        }

        int[][] array = new int[rows][cells];
        return array;
    }

    public static void main(String[] args) {
        ConvertList2Array convert = new ConvertList2Array();
        List<Integer> lists = new ArrayList<>();
        lists.add(1);
        lists.add(2);
        lists.add(3);
        lists.add(4);
        lists.add(5);
        lists.add(6);
        lists.add(7);

        Integer ia[] = new Integer [lists.size()] ;
        ia = lists.toArray(ia);

        System.out.println( "Coдepжимoe списочного массива ia : " + Arrays.toString(ia));

        System.out.println("---");
        int[][] arr2 = convert.toArray(Arrays.asList(ia), 3);

        for(int[] arr3 : arr2) {
            System.out.print(Arrays.toString(arr3));
        }


    }
}
