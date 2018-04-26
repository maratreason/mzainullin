package ru.mzainullin.oop.start;

public class ValidateInput extends ConsoleInput {

    ConsoleInput consoleInput;
    public ValidateInput(ConsoleInput consoleInput1) {
        this.consoleInput = consoleInput1;
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value =  super.ask(question, range);
                invalid = false;
            } catch (MenuOutException e) {
                System.out.println("Пожалуйста, выберите пункты от 0 до 6...");
            } catch (NumberFormatException e) {
                System.out.println("Введите корректные данные...");
            }
        } while (invalid);
        return value;
    }

}
