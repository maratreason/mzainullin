package ood.SRP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Marat Zainullin.
 * @since 02.02.2019.
 */
public class InteractCalc {

    private final Calculator calculator;
    private final Scanner scn;
    private int[] rang = {1, 2, 3, 4, 5, 6};
    List<Integer> currentAction = new ArrayList<>();
    DispatchPattern dispatchPattern;

    public InteractCalc(final Calculator calculator, final Scanner scn) {
        this.calculator = calculator;
        this.scn = scn;
        dispatchPattern = new DispatchPattern();
    }

    /**
     * Текстовая инструкция при запуске.
     */
    private void info() {
        System.out.println("Выберете один из пунктов (0-5):");
        System.out.println("Затем введите первое число и нажмите <Enter>:");
        System.out.println("После этого введите второе число и нажмите <Enter>:");
    }

    /**
     * Основное действия в калькуляторе.
     * @param calc - объект калькулятор.
     */
    public void input(Calculator calc) {

        int menuItem = scn.nextInt();
        System.out.println("Вы выбрали пункт: " + menuItem);

//        dispatchPattern.init();

        while (menuItem != 5) {
            ask(menuItem, rang);
            int first = scn.nextInt();
            int second = scn.nextInt();
            double result;

//            dispatchPattern.iterateDispatch(menuItem);

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

            showMenu();

            System.out.println("Выберте действие:");
            menuItem = scn.nextInt();
            System.out.println("Вы выбрали пункт: " + menuItem);


        }
        for (int n : currentAction) {
            System.out.print(n + " ");
        }
    }

    /**
     * Показать меню.
     */
    public void showMenu() {
        String[] menu = {"0. Сложить.", "1. Вычесть.", "2. Умножить.", "3. Делить.", "4. Повторить последнее действие.", "5. Выход из программы"};
        info();
        for (String point : menu) {
            System.out.println(point);
        }
    }

    /**
     * Ввод пользовательских данных.
     * @param number - ключ.
     * @param range - массив пунктов меню.
     * @return - выбранный ключ.
     */
    public int ask(int number, int[] range) {
        int key = number;
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        return key;
    }

}