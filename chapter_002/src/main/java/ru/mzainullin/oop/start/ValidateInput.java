package ru.mzainullin.oop.start;

/**
 * @author Marat Zainullin (maratreason@mail.ru)
 * @version 1.0
 * @since 26.04.2018
 */
public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value =  this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException e) {
                System.out.println("Пожалуйста, выберите пункты от 0 до 6...");
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста введите корректные данные...");
            }
        } while (invalid);
        return value;
    }
}
