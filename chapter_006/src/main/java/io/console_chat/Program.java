package io.console_chat;

import java.util.Random;
import java.util.Scanner;

/**
 * Программа.
 *
 * @author Marat Zainullin
 * @since 03.01.2019
 * @version 0.1
 */
public class Program {

    private Scanner scn = new Scanner(System.in);
    private String[] answers;
    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    /**
     * Случайный выбор ответов для бота.
     * @param array входящий массив строк.
     * @return возвращает случайный индекс из массива.
     */
    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    /**
     * Метод ввода данных пользователя.
     * @param question - вопрос.
     * @return answer - ответ.
     */
    public void ask(String question) throws InterruptedException {
        System.out.print(question);

        while (scn.hasNext()) {
            System.out.println("Я: " + scn.nextLine());
            System.out.println("Ответ бота: " + getRandom(getAnswers()));

            if ("exit".equals(scn.nextLine())) {
                System.exit(1);
            }

            if ("stop".equals(scn.nextLine())) {
                while (scn.hasNext()) {
                    System.out.println("Я: " + scn.nextLine());
                    System.out.println("Бот не будет отвечать пока вы не введете: continue");

                    if ("continue".equals(scn.nextLine())) {
                        break;
                    }
                }
            }

            ask("Спросите еще: ");
            break;
        }

    }

    /**
     * Приветствие.
     */
    public void showMessage() {
        System.out.println("+-------------------------+");
        System.out.println("| Welcome to the program! |");
        System.out.println("+-------------------------+");
    }

    public static void main(String[] args) throws InterruptedException {
        String[] answer = {"У меня все супер!", "Может быть в другой раз...", "Ты серьезно?"};
        Program program = new Program();
        program.setAnswers(answer);
        program.showMessage();
        program.ask("Введите любое слово...");
    }
}
