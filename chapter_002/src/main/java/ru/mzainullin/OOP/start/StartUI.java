package ru.mzainullin.OOP.start;

import ru.mzainullin.OOP.models.Item;
import ru.mzainullin.OOP.models.Task;

/**
 * @author Marat Zainullin (maratreason@mail.ru)
 * @version 1.0
 * @since 18.03.2018
 */
public class StartUI {
    public static void main(String[] args) {

        Tracker tracker = new Tracker();
        tracker.add(new Task("Task", "descTask"));
        tracker.add(new Item("Лиза", "descItem", 1));
        tracker.add(new Task("iTask", "desciTask"));
        tracker.add(new Item("iItem", "desciItem", 2));

        for(Item item : tracker.getAll()) {
            System.out.println(item.getName());
        }

    }
}
