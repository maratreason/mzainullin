package ru.mzainullin.oop.start;

import ru.mzainullin.oop.models.Item;

/**
 * @author Marat Zainullin (maratreason@mail.ru)
 * @version 1.2
 * @since 27.04.2018
 */
public class FindById extends BaseAction {

    public FindById(int key, String name) {
        super(key, name);
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Enter task's id: ");
        for (Item item : tracker.findAll()) {
            if (item.getId().equals(id)) {
                System.out.println(item.getId() + " " + item.getName() + " " + item.getDescription());
            }
        }
    }

}
