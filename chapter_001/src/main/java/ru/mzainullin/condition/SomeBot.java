package ru.mzainullin.condition;

/**
* @author Marat Zainullin
* @version 1.0
* @since 0.1
*/
public class SomeBot {

	/**
	* Ответ на вопросы
	* @param question вопрос от клиента.
	* @return Ответ.
	*/
	public String answer(String question) {
		String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
		if ("Привет, Бот.".equals(question)) {
			rsl = "Привет, умник.";
		} else if ("Пока.".equals(question)) {
			rsl = "До скорой встречи.";
		}
		return rsl;
	}


	// public static void main(String[] args) {
	// 	SomeBot newBot = new SomeBot();
	// 	System.out.println(newBot.answer("Привет, Бот"));
	// }


}