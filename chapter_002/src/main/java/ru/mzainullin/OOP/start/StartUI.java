package ru.mzainullin.OOP.start;

import ru.mzainullin.OOP.models.Item;
import ru.mzainullin.OOP.models.Task;

/**
 * @author Marat Zainullin (maratreason@mail.ru)
 * @version 1.0
 * @since 18.03.2018
 */
public class StartUI {

    private Input input;

    public StartUI(Input input) {
        this.input = input;
    }

    public void init() {
        String name = input.ask("Введите имя");
        Tracker tracker = new Tracker();
        tracker.add(new Task(name, "firstDesc"));

        for(Item item : tracker.findAll()) {
            System.out.println(item.getName());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUI(input).init();
    }
}