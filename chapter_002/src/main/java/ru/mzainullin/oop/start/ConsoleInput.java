package ru.mzainullin.oop.start;

import java.util.Scanner;

/**
 * @author Marat Zainullin (maratreason@mail.ru)
 * @version 1.0
 * @since 02.04.2018
 */
public class ConsoleInput implements Input {

	private Scanner scn = new Scanner(System.in);

	/**
	 * Метод ввода данных пользователя.
	 * При каждом вызове метода ask мы увеличиваем счетчик и
	 * при следующем вызове он вернет нам новое значение.
	 * @param question - вопрос
	 * @return answer - ответ
	 */
	public String ask(String question) {
		System.out.print(question);
		return scn.nextLine();
	}

	/**
	 * Перегруженный метод ввода данных пользователя.
	 * @param question - первый параметр
	 * @param range - второй параметр. диапазон
	 * @return exception or key
	 */
	public int ask(String question, int[] range) {
		int key = Integer.valueOf(this.ask(question));
		boolean exist = false;
		for (int value : range) {
			if (value == key) {
				exist = true;
				break;
			}
		}
		if (!exist) {
			throw new MenuOutException("Вы вышли за пределы выбора пунктов меню.");
		}
		return key;
	}
}