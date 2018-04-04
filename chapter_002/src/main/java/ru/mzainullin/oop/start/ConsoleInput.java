package ru.mzainullin.oop.start;

import java.util.Scanner;

/**
 * @author Marat Zainullin (maratreason@mail.ru)
 * @version 1.0
 * @since 02.04.2018
 */
public class ConsoleInput implements Input {

	private Scanner scn = new Scanner(System.in);

	public String ask(String question) {
		System.out.print(question);
		return scn.nextLine();
	}

}