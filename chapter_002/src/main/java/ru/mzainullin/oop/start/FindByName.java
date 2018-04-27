package ru.mzainullin.oop.start;

import ru.mzainullin.oop.models.Item;

/**
 * @author Marat Zainullin (maratreason@mail.ru)
 * @version 1.2
 * @since 27.04.2018
 */
public class FindByName extends BaseAction {

    public FindByName(int key, String name) {
        super(key, name);
    }

    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Enter task's name: ");
        for (Item item : tracker.findAll()) {
            if (item.getName().equals(name)) {
                System.out.println(item.getId() + " " + item.getName() + " " + item.getDescription());
            }
        }
    }

}
