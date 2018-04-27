package ru.mzainullin.oop.start;

import ru.mzainullin.oop.models.Task;

/**
 * @author Marat Zainullin (maratreason@mail.ru)
 * @version 1.2
 * @since 27.04.2018
 */
public class AddItem extends BaseAction {

    public AddItem(int key, String name) {
        super(key, name);
    }

    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Enter the new task name: ");
        String desc = input.ask("Enter the new task desc: ");
        tracker.add(new Task(name, desc));
    }

}
