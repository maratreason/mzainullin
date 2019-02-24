package ood.SRP.new_interact_calc;

import ood.SRP.Calculator;

import java.util.Scanner;

/**
 * @author Marat Zainullin.
 * @version 0.1.
 * @since 24.02.2019.
 */
public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        DefaultAction menuAction = new DefaultAction();
        UserAction user = new UserAction();
        Scanner scn = new Scanner(System.in);
        InteractCalculator interactCalc = new InteractCalculator(menuAction, scn);
        menuAction.showMenu();
        interactCalc.input(calc, user);
    }
}
