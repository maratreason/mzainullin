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

        int size = Math.min(left.length(), right.length());

        int result = 0;

        for (int i = 0; i != size; i++) {
            if (result != 0) {
                break;
            }
            if (left.charAt(i) > right.charAt(i)) {
                result = Character.compare(left.charAt(i), right.charAt(i));
            } else if (left.charAt(i) < right.charAt(i)) {
                result = Character.compare(right.charAt(i), left.charAt(i));
            } else {
                result = 0;
            }
        }

        if (result == 0 && left.length() != right.length()) {
            result = left.compareTo(right);
        } else {
            result = left.compareTo(right);
        }
            return result;
    }
}
