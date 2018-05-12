package ru.mzainullin.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 10.05.2018
 */
public class ListCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {

        int result = 0;

        char[] leftValue = left.toCharArray();
        char[] rightValue = right.toCharArray();

        for (int i = 0; i != leftValue.length; i++) {
            for (int j = 0; j != rightValue.length; j++) {
                if (leftValue.length > rightValue.length) {
                    result = -1;
                } if (leftValue.length < rightValue.length) {
                    result = 1;
                } else {
                    result = 0;
                }
            }
        }
        return result;
    }
}

/**
* Очень часто возникает ситуация, когда нужно сравнить два слова.
* У нас есть готовый метод String.compareTo.
* В это задании нужно создать подобный метод самому.
*
* - Вам нужно реализовать компаратор для сравнения двух массивов символов.
*
* - Необходимо реализовать поэлементное сравнение двух списков, т.е. сравниваем элементы двух списков,
* находящихся на одних и тех же позициях (по одним и тем же индексом). Сравнение в лексикографическом порядке.
*
* - В этом задании нельзя использовать метод String.compateTo.
*
* - Вы можете использовать:
* String.charAt(int index)
* Integer.compare(int left, int right),
* Character.compare(char left, char right);
*/
