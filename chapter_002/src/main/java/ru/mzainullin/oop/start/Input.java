package ru.mzainullin.oop.start;

/**
 * @author Marat Zainullin (maratreason@mail.ru)
 * @version 1.1
 * @since 25.04.2018
 */
public interface Input {

	/**
	 * Метод ввода данных пользователя.
	 * @param question - Вопрос
	 * @return - Ответ
	 */
	String ask(String question);

	/**
	 * Перегруженный метод ввода данных пользователя.
	 * @param question - Вопрос
	 * @param range - Диапазон
	 * @return - Ответ
	 */
	int ask(String question, int[] range);
}