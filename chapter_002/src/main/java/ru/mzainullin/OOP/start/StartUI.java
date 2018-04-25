package ru.mzainullin.oop.start;

import ru.mzainullin.oop.models.Item;

/**
 * @author Marat Zainullin (maratreason@mail.ru)
 * @version 1.1
 * @since 18.03.2018
 * Консольное приложение
 */
public class StartUI {

    private final Input input;
    private final Tracker tracker;
    private int[] ranges = new int[] {0, 1, 2, 3, 4, 5, 6, 7};

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.tracker = tracker;
        this.input = input;
    }


    public void init() {
        boolean exit = false;
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        while(!exit) {
            menu.show();
            int key = Integer.valueOf(input.ask("select: ", ranges));
            menu.select(key);
            if("6".equals(String.valueOf(key))) {
                exit = true;
            }
        }
    }


    public static void main(String[] args) {
        Input input = new ValidateInput();
        new StartUI(input, new Tracker()).init();
    }

}