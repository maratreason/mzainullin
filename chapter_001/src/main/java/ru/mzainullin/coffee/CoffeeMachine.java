package ru.mzainullin.coffee;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 01.05.2018
 */
public class CoffeeMachine {

    int[] coins = {1, 2, 5, 10};

    int[] changes(int value, int price) {

        int position = 0;
        int summ = 0;
        int backMoney = value - price;
        int[] returnMoney = new int[100];

//        for (int i = 0; i < value; i++) {
//            if(coins[3] <= backMoney) {
//                returnMoney[position++] = coins[3];
//                backMoney -= coins[3];
//            } else if (coins[2] <= backMoney && coins[3] > backMoney) {
//                returnMoney[position++] = coins[2];
//                backMoney -= coins[2];
//            } else if (coins[1] <= backMoney && coins[2] > backMoney) {
//                returnMoney[position++] = coins[1];
//                backMoney -= coins[1];
//            } else if (coins[0] <= backMoney && coins[1] > backMoney) {
//                returnMoney[position++] = coins[0];
//                backMoney -= coins[0];
//            }
//        }

        for (int coin : coins) {
            while (value - coin > 0) {
                OptionalInt max = Arrays.stream(coins).max();
                int maxCoin = max.getAsInt();
                returnMoney[position++] = maxCoin;
//                if (backMoney < maxCoin) {
//
//                }
                backMoney -= coin;
                value -= coin;
            }
        }

        for (int money : returnMoney) {
            if (money == 0) {
                break;
            } else {
                System.out.print(money + " ");
                summ += money;
            }
        }
        System.out.println("\nУважаемый клиент, вот ваша сдача: " + summ + " евро.");
        return returnMoney;
    }
}