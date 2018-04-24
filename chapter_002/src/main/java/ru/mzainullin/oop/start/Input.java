package ru.mzainullin.oop.start;

/**
 * @author Marat Zainullin (maratreason@mail.ru)
 * @version 1.0
 * @since 02.04.2018
 */
public interface Input {
	/**
	 *
	 * @param question - Вопрос
	 * @return - Ответ
	 */
	String ask(String question);

	/**
	 *
	 * @param question - Вопрос
	 * @param range - Диапазон
	 * @return - Ответ
	 */
	int ask(String question, int[] range);
}