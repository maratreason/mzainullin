package io.console_chat;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Marat Zainullin.
 * @since 20.01.2019.
 * @version 0.2.
 */
public class BaseAction implements Action {

    private Scanner scn;
    private String[] answers;

    /**
     * Случайный выбор ответов для бота.
     * @param array входящий массив строк.
     * @return возвращает случайный индекс из массива.
     */
    @Override
    public String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    /**
     * Метод ввода данных пользователя.
     * @param bot виртуальный бот.
     * @param question - вопрос.
     */
    @Override
    public void ask(Bot bot, String question) {
        System.out.print(question);
        scn = new Scanner(System.in);

        while (scn.hasNext()) {
            String ans = scn.nextLine();
            writeLog(ans);
            System.out.println("Я: " + ans);
            writeLog("Я: " + ans);

                if (ans.equals("stop")) {
                    System.out.println("Бот не будет отвечать пока вы не введете: continue");
                    writeLog("Бот не будет отвечать пока вы не введете: continue");
                    while (scn.hasNext()) {
                        System.out.println("Я: " + ans);
                        writeLog("Я: " + ans);
                        System.out.println("Бот не будет отвечать пока вы не введете: continue");
                        writeLog("Бот не будет отвечать пока вы не введете: continue");
                        if ("continue".equals(scn.nextLine())) {
                            break;
                        }
                    }
                }

                if ("exit".equals(ans)) {
                    System.out.println("Выход из программы.");
                    writeLog("Выход из программы.");
//                    throw new RuntimeException("Выход из прораммы");
                    return;
                } else {
                    System.out.println("Ответ бота: " + getRandom(bot.getAnswers()));
                    writeLog("Ответ бота: " + getRandom(bot.getAnswers()));
                    ask(bot, "Спросите еще: ");
                    writeLog("Спросите еще: ");
                    break;
                }
        }
    }

    /**
     * Приветствие.
     */
    @Override
    public void showMessage() {
        System.out.println("+-------------------------+");
        System.out.println("| Welcome to the program! |");
        System.out.println("+-------------------------+");
        writeLog("+-------------------------+");
        writeLog("| Welcome to the program! |");
        writeLog("+-------------------------+");
    }

    /**
     * Запись лога в txt-файл.
     */
    @Override
    public void writeLog(String str) {
        File file = new File("chapter_006/src/main/java/io/console_chat/log.txt");
        try (FileWriter writer = new FileWriter(file.getPath(), true);
             BufferedWriter buff = new BufferedWriter(writer)
        ) {
            buff.write(str + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
