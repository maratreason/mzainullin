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
    private String[] menu;
    int[] rang = {1, 2, 3, 4, 5, 6};
    List<Integer> currentAction = new ArrayList<>();

    private String[] getMenu() {
        return menu;
    }

    private InteractCalc(final Calculator calculator, final Scanner scn) {
        this.calculator = calculator;
        this.scn = scn;
    }

    /**
     * пункты меню (0-5).
     */
    private void menuInit() {
        menu = new String[6];
        menu[0] = "0. Сложить.";
        menu[1] = "1. Вычесть.";
        menu[2] = "2. Умножить.";
        menu[3] = "3. Делить.";
        menu[4] = "4. Повторить последнее действие.";
        menu[5] = "5. Выход из программы";
    }

    /**
     * Текстовая инструкция при запуске.
     */
    private void info() {
        System.out.println("---Программа---");
        System.out.println("Для начала выберете нужное действие выбрав один из пунктов (0-5):");
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

        while (menuItem != 5) {
            ask(menuItem, rang);
            int first = scn.nextInt();
            int second = scn.nextInt();
            int repeat;
            double result;

            if (menuItem == 0) {
                System.out.println("Сложение:");
                result = calc.add(first, second);
                System.out.println(result);
                currentAction.add(menuItem);
            } else if (menuItem == 1) {
                System.out.println("Вычитание:");
                result = calc.subtract(first, second);
                System.out.println(result);
                currentAction.add(menuItem);
            } else if (menuItem == 2) {
                System.out.println("Умножение:");
                result = calc.multiple(first, second);
                System.out.println(result);
                currentAction.add(menuItem);
            } else if (menuItem == 3) {
                System.out.println("Деление:");
                result = calc.divide(first, second);
                System.out.println(result);
                currentAction.add(menuItem);
            } else if (menuItem == 4) {
                System.out.println("Переиспользование предыдущего вычисления:");
                repeat = currentAction.get(currentAction.size() - 1);
                // Не знаю как реализовать этот метод.
            }

            System.out.println("Выберте действие:");
            menuItem = scn.nextInt();
            System.out.println("Вы выбрали пункт: " + menuItem);
        }
    }

    /**
     * Показат меню.
     */
    private void showMenu() {
        menuInit();
        info();
        for (String point : this.getMenu()) {
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


    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner scn = new Scanner(System.in);
        InteractCalc interactCalc = new InteractCalc(calc, scn);

        interactCalc.showMenu();
        interactCalc.input(calc);
    }

}