package ru.mzainullin.oop.start;

import ru.mzainullin.oop.models.Item;

/**
 * @author Marat Zainullin (maratreason@mail.ru)
 * @version 1.0
 * @since 18.03.2018
 * Консольное приложение
 */
public class StartUI {

    // Переделать значения должны быть из меню.
    private int[] ranges = new int[] {0, 1, 2, 3, 4, 5, 6};

    //Получение данных от пользователя.
    private final Input input;

    //Хранилище заявок.
    private final Tracker tracker;


    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.tracker = tracker;
        this.input = input;
    }


    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            menu.select(input.ask("select:", ranges));
        } while (!"y".equals(this.input.ask("Exit? y/n : ")));


    }


    public static void main(String[] args) {
        Item item = new Item();
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, new Tracker()).init();
    }

}