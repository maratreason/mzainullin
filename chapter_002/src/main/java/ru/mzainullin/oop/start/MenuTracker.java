package ru.mzainullin.oop.start;

import ru.mzainullin.oop.models.Item;
import ru.mzainullin.oop.models.Task;


class Exit implements UserAction {

    public int key() {
        return 6;
    }

    public void execute(Input input, Tracker tracker) {

    }

    public String info() {
        return String.format("%s. %s", this.key(), "Exit");
    }
}


class EditItem implements UserAction {
    public int key() {
        return 2;
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Enter task's id: ");
        String name = input.ask("Enter the new task name: ");
        String desc = input.ask("Enter the new task desc: ");
        Task task = new Task(name, desc);
        task.setId(id);
        tracker.edit(task);
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Edit the new Item.");
    }
}


class DeleteItem implements UserAction {
    public int key() {
        return 3;
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Enter task's id you want to delete: ");
        for (Item item : tracker.findAll()) {
            if (item != null && item.getId().equals(id)) {
                tracker.delete(item.getId());
            }
        }
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Delete current task.");
    }
}


class FindById implements UserAction {
    public int key() {
        return 4;
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Enter task's id: ");
        for (Item item : tracker.findAll()) {
            if (item.getId().equals(id)) {
                System.out.println(item.getId() + " " + item.getName() + " " + item.getDescription());
            }
        }
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Find task by id.");
    }
}


class FindByName implements UserAction {
    public int key() {
        return 5;
    }

    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Enter task's name: ");
        for (Item item : tracker.findAll()) {
            if (item.getName().equals(name)) {
                System.out.println(item.getId() + " " + item.getName() + " " + item.getDescription());
            }
        }
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Find task by name.");
    }
}


/**
 * @author Marat Zainullin
 * @version 1.1
 * @since 25.04.2018
 */
public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindById();
        this.actions[5] = new FindByName();
        this.actions[6] = new Exit();
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }


    public void show() {
        for (UserAction action : this.actions) {
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


    private static class ShowItems implements UserAction {

        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                if (item != null) {
                    System.out.println(String.format("%s. %s", item.getId(), item.getName()));
                }
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }
    }
}