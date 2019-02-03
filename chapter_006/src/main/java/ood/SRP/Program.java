package ood.SRP;

import java.util.Scanner;

/**
 * @author Marat Zainullin.
 * @version 0.1.
 * @since 03.02.2019.
 */
public class Program {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner scn = new Scanner(System.in);
        InteractCalc interactCalc = new InteractCalc(calc, scn);

        interactCalc.showMenu();
        interactCalc.input(calc);
    }
}
