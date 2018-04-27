package ru.mzainullin.oop.start;

import ru.mzainullin.oop.models.Item;

/**
 * @author Marat Zainullin (maratreason@mail.ru)
 * @version 1.2
 * @since 27.04.2018
 */
public class DeleteItem extends BaseAction {

    public DeleteItem(int key, String name) {
        super(key, name);
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Enter task's id you want to delete: ");
        for (Item item : tracker.findAll()) {
            if (item != null && item.getId().equals(id)) {
                tracker.delete(item.getId());
            }
        }
    }
}
