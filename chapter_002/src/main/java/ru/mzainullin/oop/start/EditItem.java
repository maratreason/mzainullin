package ru.mzainullin.oop.start;

import ru.mzainullin.oop.models.Task;

public class EditItem extends BaseAction {

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
