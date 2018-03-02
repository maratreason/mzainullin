package ru.mzainullin.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* @author Marat Zainullin
* @version 1.0
* @since 0.1
*/
public class SomeBotTest {

	@Test
	public void whenGreetBot() {
		SomeBot bot = new SomeBot();
		assertThat(
				bot.answer("Привет, Бот."),
				is("Привет, умник.")
			);
	}

	@Test
	public void whenBuyBot() {
		SomeBot bot = new SomeBot();
		assertThat(
				bot.answer("Пока."),
				is("До скорой встречи.")
			);
	}

	@Test
	public void whenDefaultBot() {
		SomeBot bot = new SomeBot();
		assertThat(
				bot.answer("Как дела?"),
				is("Это ставит меня в тупик. Спросите другой вопрос.")
			);
	}

}