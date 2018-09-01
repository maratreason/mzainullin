package ru.mzainullin.oop.start;

import ru.mzainullin.oop.models.Item;
import ru.mzainullin.oop.models.Task;

import java.util.ArrayList;
import java.util.List;

class ShowAllItems extends BaseAction {

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

class AddItem extends BaseAction {

    public AddItem(int key, String name) {
        super(key, name);
    }

    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Enter the new task name: ");
        String desc = input.ask("Enter the new task desc: ");
        tracker.add(new Task(name, desc));
    }

}

class DeleteItem extends BaseAction {

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

class EditItem extends BaseAction {

    public EditItem(int key, String name) {
        super(key, name);
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Enter task's id: ");
        String name = input.ask("Enter the new task name: ");
        String desc = input.ask("Enter the new task desc: ");
        Task task = new Task(name, desc);
        task.setId(id);
        tracker.edit(task);
    }
}

class FindById extends BaseAction {

    public FindById(int key, String name) {
        super(key, name);
    }

    List<Item> findItems = new ArrayList<>();

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Enter task's id: ");
        findItems.add(tracker.findById(id));
    }
}

class FindByName extends BaseAction {

    public FindByName(int key, String name) {
        super(key, name);
    }

    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Enter task's name: ");
        tracker.findByName(name);
    }
}


class Exit extends BaseAction {
    public Exit(int key, String name) {
        super(key, name);
    }
    public void execute(Input input, Tracker tracker) {
    }
}

/**
 * @author Marat Zainullin
 * @version 1.2
 * @since 07.05.2018
 */
public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();
    private int position = 0;

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions.add(position++, new AddItem(0, "Add the new Item."));
        this.actions.add(position++, new ShowAllItems(1, "Show all items."));
        this.actions.add(position++, new EditItem(2, "Edit the new Item."));
        this.actions.add(position++, new DeleteItem(3, "Delete current task."));
        this.actions.add(position++, new FindById(4, "Find task by id."));
        this.actions.add(position++, new FindByName(5, "Find task by name."));
        this.actions.add(position++, new Exit(6, "Exit"));
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }


    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}