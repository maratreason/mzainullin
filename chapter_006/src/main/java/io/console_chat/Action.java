package io.console_chat;

/**
 * @author Marat Zainullin.
 * @since 20.01.2019.
 * @version 0.2.
 */
public interface Action {

    /**
     * Случайный выбор строкт из массива строк.
     * @param array входящий массив строк.
     */
    String getRandom(String[] array);

    /**
     * Ввод данных пользователя.
     * @param question - вопрос.
     */
    void ask(Bot bot, String question);

    /**
     * Приветствие.
     */
    void showMessage();

    /**
     * Запись в лог.
     */
    void writeLog(String str);
}
