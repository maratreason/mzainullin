package ood.SRP.new_interact_calc;

import ood.SRP.Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Marat Zainullin.
 * @version 0.1.
 * @since 24.02.2019.
 */
public class InteractCalculator {
    private final DefaultAction action;
    private final Scanner scn;
    private int[] rang = {1, 2, 3, 4, 5, 6};
    List<Integer> currentAction = new ArrayList<>();

    public InteractCalculator(final DefaultAction action, final Scanner scn) {
        this.action = action;
        this.scn = scn;
    }

    /**
     * Основное действия в калькуляторе.
     * @param calc - объект калькулятор.
     */
    public void input(Calculator calc, UserAction user) {

        int menuItem = scn.nextInt();
        System.out.println("Вы выбрали пункт: " + menuItem);

        while (menuItem != 5) {
            user.ask(menuItem, rang);
            int first = scn.nextInt();
            int second = scn.nextInt();
            double result;

            if (menuItem == 0) {
                result = calc.add(first, second);
                System.out.println("Результат вычисления: " + result + "\n");
            } else if (menuItem == 1) {
                result = calc.subtract(first, second);
                System.out.println("Результат вычисления: " + result + "\n");
            } else if (menuItem == 2) {
                result = calc.multiple(first, second);
                System.out.println("Результат вычисления: " + result + "\n");
            } else if (menuItem == 3) {
                result = calc.divide(first, second);
                System.out.println("Результат вычисления: " + result + "\n");
            } else if (menuItem == 4) {
                System.out.println("Переиспользование предыдущего вычисления:");
                for (int i = 0; i < currentAction.size(); i++) {
                    menuItem = currentAction.get(currentAction.size() - 1);
                    if (menuItem == 0) {
                        result = calc.add(first, second);
                        System.out.println("Результат вычисления: " + result + "\n");
                        break;
                    } else if (menuItem == 1) {
                        result = calc.subtract(first, second);
                        System.out.println("Результат вычисления: " + result + "\n");
                        break;
                    } else if (menuItem == 2) {
                        result = calc.multiple(first, second);
                        System.out.println("Результат вычисления: " + result + "\n");
                        break;
                    } else if (menuItem == 3) {
                        result = calc.divide(first, second);
                        System.out.println("Результат вычисления: " + result + "\n");
                        break;
                    }
                }
                currentAction.add(menuItem);
            }
            currentAction.add(menuItem);

            action.showMenu();

            System.out.println("Выберте действие:");
            menuItem = scn.nextInt();
            System.out.println("Вы выбрали пункт: " + menuItem);
        }
        for (int n : currentAction) {
            System.out.print(n + " ");
        }
    }

}