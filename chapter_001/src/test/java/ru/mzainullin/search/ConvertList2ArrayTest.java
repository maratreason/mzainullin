package ru.mzainullin.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 02.05.2018
 */
public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void whenGetListAndConvertToNewList() {
        int[] num = {1, 2, 3, 4, 5};
        ConvertList2Array list = new ConvertList2Array();
        List<int[]> someList = new ArrayList<>();
        someList.addAll(Arrays.asList(num));

        someList.add(new int[]{7, 8, 9});

        List<Integer> new2List = new ArrayList<>();
        new2List.addAll(list.convert(someList));

        assertThat(list.convert(someList), is(new2List));
    }
}
