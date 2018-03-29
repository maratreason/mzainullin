package ru.mzainullin.OOP.start;

import ru.mzainullin.OOP.models.Item;
import ru.mzainullin.OOP.models.Task;


public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Task("Task", "descTask"));
        tracker.add(new Item("Лиза", "descItem", 1));
        tracker.add(new Task("iTask", "desciTask"));
        tracker.add(new Item("iItem", "desciItem", 2));

        for(Item item : tracker.getAll()) {
            System.out.println(item.getName());
        }

        Item previous = new Item("previous","testDescription",123L);
        tracker.add(previous);

        Item next = new Item("next","testDescription2",1234L);
        tracker.add(next);

        next.setId(previous.getId());

        System.out.println("---------------");

        for(Item item : tracker.getAll()) {
            System.out.println(item.getName());
        }
        System.out.println("---------------");

        tracker.replace(previous.getId(), next);
        for(Item item : tracker.getAll()) {
            System.out.println(item.getName());
        }
        System.out.println("---------------");

        System.out.println("delete");
        tracker.delete(previous.getId());

        for(Item item : tracker.getAll()) {
            System.out.println(item.getName());
        }

    }
}
