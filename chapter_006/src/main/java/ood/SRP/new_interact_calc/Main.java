package ood.SRP.new_interact_calc;

import ood.SRP.new_interact_calc.trig_calculate.TrigCalculator;
import ood.SRP.new_interact_calc.trig_calculate.TrigMenu;

import java.util.Scanner;

/**
 * @author Marat Zainullin.
 * @version 0.1.
 * @since 24.02.2019.
 */
public class Main {
    public static void main(String[] args) {
        Calculator calc = new TrigCalculator();
        DefaultAction menuAction = new TrigMenu();
        UserAction user = new UserAction();
        Scanner scn = new Scanner(System.in);
        InteractCalculator interactCalc = new InteractCalculator(menuAction, scn);
        menuAction.showMenu();
        interactCalc.input(calc, user);
    }
}
