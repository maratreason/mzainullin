package ru.mzainullin.oop.start;

import ru.mzainullin.oop.models.Item;
import ru.mzainullin.oop.models.Task;

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

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Enter task's id: ");
        for (Item item : tracker.findAll()) {
            if (item.getId().equals(id)) {
                System.out.println(item.getId() + " " + item.getName() + " " + item.getDescription());
            }
        }
    }
}

class FindByName extends BaseAction {

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

class Exit extends BaseAction {
    public Exit(int key, String name) {
        super(key, name);
    }
    public void execute(Input input, Tracker tracker) {}
}

/**
 * @author Marat Zainullin (maratreason@mail.ru)
 * @version 1.2
 * @since 27.04.2018
 * Консольное приложение
 */
public class StartUI {

    private final Input input;
    private final Tracker tracker;
    private int[] ranges = new int[] {0, 1, 2, 3, 4, 5, 6};

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.tracker = tracker;
        this.input = input;
    }


    public void init() {
        boolean exit = false;
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        showMessage();
        menu.fillActions();

        while(!exit) {
            menu.show();
            int key = Integer.valueOf(input.ask("select: ", ranges));
            menu.select(key);
            if("6".equals(String.valueOf(key))) {
                exit = true;
            }
        }
    }

    public void showMessage() {
        System.out.println("+-------------------------+");
        System.out.println("| Welcome to the program! |");
        System.out.println("+-------------------------+");
    }


    public static void main(String[] args) {

        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}