package io.console_chat;

import java.io.IOException;
import java.util.Date;


/**
 * Программа.
 *
 * @author Marat Zainullin.
 * @since 20.01.2019.
 * @version 0.2.
 */
public class Program extends BaseAction {
    public static void main(String[] args)  {
        Program program = new Program();
        program.writeLog("\n|---Запись лога---|\n" + new Date().toString());
        Bot bot = new Bot();
        String[] answer = {"У меня все супер!", "Может быть в другой раз...", "Ты серьезно?"};
        bot.setAnswers(answer);
        program.showMessage();
        program.ask(bot, "Введите любое слово...");
    }
}
