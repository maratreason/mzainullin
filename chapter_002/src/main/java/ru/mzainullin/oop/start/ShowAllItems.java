package ru.mzainullin.oop.start;

import ru.mzainullin.oop.models.Item;

public class ShowAllItems extends BaseAction {

    public ShowAllItems(int key, String name) {
        super(key, name);
    }

    public void execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            if (item != null) {
                System.out.println(String.format("%s. %s", item.getId(), item.getName()));
            }
        }
    }
}
