package ru.mzainullin.oop.start;

import ru.mzainullin.oop.models.Task;

/**
 * @author Marat Zainullin
 * @version 1.1
 * @since 20.04.2018
 */
public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[5];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = new AddItem();
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Метод печатающий заявку.
     */
    public void show() {
        for(UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem implements UserAction {

        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter the new task name: ");
            String desc = input.ask("Enter the new task desc: ");
            tracker.add(new Task(name, desc));
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add the new Item.");
        }
    }
}
