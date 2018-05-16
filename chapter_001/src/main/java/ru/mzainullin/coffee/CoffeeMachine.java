package ru.mzainullin.coffee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 01.05.2018
 */
public class CoffeeMachine {

    int[] coins = {1, 2, 5, 10};

    int[] changes(int value, int price) {

        int backMoney = value - price;
        int index = coins.length - 1;
        List<Integer> lists = new ArrayList<>();

        while (backMoney > 0) {
            while (backMoney >= coins[index]) {
                lists.add(coins[index]);
                backMoney -= coins[index];
            }
            index--;
        }
        int[] result = new int[lists.size()];
        for (int i = 0; i != result.length; i++) {
            result[i] = lists.get(i);
        }
        System.out.println(String.format("\nУважаемый клиент, вот ваша сдача состоит из: %s монет.", Arrays.toString(result)));

        return result;
    }
}