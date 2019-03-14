package ood.SRP.new_interact_calc;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author Marat Zainullin.
 * @version 0.1.
 * @since 24.02.2019.
 */
public class InteractCalculator {
    private final DefaultAction action;
    private final Scanner scn;
    private int[] rang = {1, 2, 3, 4, 5, 6};
    Map<Integer, Double> calcActions = new HashMap<>();
    List<Integer> currentAction = new ArrayList<>();
    private Calculator calc;

    Map<String, Double> actions = new HashMap<>();

    public InteractCalculator(final DefaultAction action, final Scanner scn) {
        this.action = action;
        this.scn = scn;
        actions.put("add", this.add(calc, scn));
        actions.put("subtract", this.subtract(calc, scn));
        actions.put("multiple", this.multiple(calc, scn));
        actions.put("divide", this.divide(calc, scn));
    }


//    /**
//     * Добавить действия.
//     * @param first 1-й параметр.
//     * @param second 2-й параметр.
//     */
//    public void addActions(int first, int second) {
//        calcActions.put(0, new Calculator().add(first, second));
//        calcActions.put(1, new Calculator().subtract(first, second));
//        calcActions.put(2, new Calculator().multiple(first, second));
//        calcActions.put(3, new Calculator().divide(first, second));
//    }

    public double add(Calculator calculator, Scanner scn) {
        return calculator.add(scn.nextInt(), scn.nextInt());
    }

    public double subtract(Calculator calculator, Scanner scn) {
        return calculator.subtract(scn.nextInt(), scn.nextInt());
    }

    public double multiple(Calculator calculator, Scanner scn) {
        return calculator.multiple(scn.nextInt(), scn.nextInt());
    }

    public double divide(Calculator calculator, Scanner scn) {
        return calculator.divide(scn.nextInt(), scn.nextInt());
    }


    /**
     * Основное действия в калькуляторе.
     * @param calc - объект калькулятор.
     */
    public void input(Calculator calc, UserAction user) {
        int menuItem = scn.nextInt();
        System.out.println("Вы выбрали пункт: " + menuItem);
        currentAction.add(menuItem);

        while (menuItem != 5) {
            user.ask(menuItem, rang);
            int first = scn.nextInt();
            int second = scn.nextInt();
//            addActions(first, second);

            for (String result : actions.keySet()) {
                if (result.equals(String.valueOf(menuItem)) && !result.equals(String.valueOf(4))) {
                    System.out.println(calcActions.get(result));
                    break;
                } else {
                    System.out.println(calcActions.get(currentAction.get(currentAction.size()-1)));
                }
            }

            action.nextShowMenu();

            System.out.println("Выберте действие:");
            menuItem = scn.nextInt();
            System.out.println("Вы выбрали пункт: " + menuItem);
        }
    }



}