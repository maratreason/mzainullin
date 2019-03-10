package ood.SRP.new_interact_calc;

import java.util.*;

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

    public InteractCalculator(final DefaultAction action, final Scanner scn) {
        this.action = action;
        this.scn = scn;
    }


    /**
     * Добавить действия.
     * @param first 1-й параметр.
     * @param second 2-й параметр.
     */
    public void addActions(int first, int second) {
        calcActions.put(0, new Calculator().add(first, second));
        calcActions.put(1, new Calculator().subtract(first, second));
        calcActions.put(2, new Calculator().multiple(first, second));
        calcActions.put(3, new Calculator().divide(first, second));
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
            addActions(first, second);

            for (Integer result : calcActions.keySet()) {
                if (menuItem == result && menuItem != 4) {
                    System.out.println(calcActions.get(menuItem));
                    break;
                } else {
                    System.out.println(calcActions.get(currentAction.get(currentAction.size()-1)));
                }
            }
            currentAction.add(menuItem);
            action.showMenu();

            System.out.println("Выберте действие:");
            menuItem = scn.nextInt();
            System.out.println("Вы выбрали пункт: " + menuItem);
        }
    }

}