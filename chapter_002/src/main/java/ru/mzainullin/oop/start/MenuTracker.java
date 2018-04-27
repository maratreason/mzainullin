package ru.mzainullin.oop.start;

/**
 * @author Marat Zainullin
 * @version 1.2
 * @since 27.04.2018
 */
public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[8];
    private int position = 0;

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[position++] = new AddItem(0, "Add the new Item.");
        this.actions[position++] = new ShowAllItems(1, "Show all items.");
        this.actions[position++] = new EditItem(2, "Edit the new Item.");
        this.actions[position++] = new DeleteItem(3, "Delete current task.");
        this.actions[position++] = new FindById(4, "Find task by id.");
        this.actions[position++] = new FindByName(5, "Find task by name.");
        this.actions[position++] = new Exit(6, "Exit");
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
}