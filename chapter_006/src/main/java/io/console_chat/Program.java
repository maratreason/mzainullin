package io.console_chat;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

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
    private String log;

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
     */
    public void ask(String question) throws InterruptedException, IOException {
        System.out.print(question);
        while (scn.hasNext()) {
            String ans = scn.nextLine();
            System.out.println("Я: " + ans);

            if ("exit".equals(ans)) {
                System.exit(1);
            }

            if (ans.equals("stop")) {
                while (scn.hasNext()) {
                    System.out.println("Я: " + scn.nextLine());
                    System.out.println("Бот не будет отвечать пока вы не введете: continue");

                    if ("continue".equals(scn.nextLine())) {
                        break;
                    }
                }
            }
            System.out.println("Ответ бота: " + getRandom(getAnswers()));
            ask("Спросите еще: ");
            break;
        }

    }

    /**
     * Приветствие.
     */
    private void showMessage() {
        System.out.println("+-------------------------+");
        System.out.println("| Welcome to the program! |");
        System.out.println("+-------------------------+");
    }

    /**
     * Запись в лога в txt-файл.
     */
    private void createLog() {
        PrintStream logfile = null;
        try {
            logfile = new PrintStream(new FileOutputStream("D:\\project\\mzainullin\\chapter_006\\src\\main\\java\\io\\console_chat\\log.txt"));
        }
        catch (FileNotFoundException e) {
            System.err.println("Отсутствует файл.");
            System.exit(1);
        }
        System.setOut(logfile);
    }


    public static void main(String[] args) throws InterruptedException, IOException {
        Program program = new Program();
        program.createLog();
        String[] answer = {"У меня все супер!", "Может быть в другой раз...", "Ты серьезно?"};
        program.setAnswers(answer);
        program.showMessage();
        program.ask("Введите любое слово...");
    }
}
