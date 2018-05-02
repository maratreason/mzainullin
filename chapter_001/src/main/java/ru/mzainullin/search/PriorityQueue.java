package ru.mzainullin.search;

import java.util.LinkedList;

public class PriorityQueue {

    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        //TODO добавить вставку в связанный список.
        if (task.getPriority() == 5) {
            this.tasks.add(task);
        } else if (task.getPriority() == 1) {
            this.tasks.add(task);
        } else if (task.getPriority() == 3) {
            this.tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }

    public static void main(String[] args) {

        LinkedList<Task> tasks1 = new LinkedList<>();

        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("1 Задача низкого приоритета", 5));
        tasks1.add(queue.take());
        queue.put(new Task("2 Задача высокого приоритета", 1));
        tasks1.add(queue.take());
        queue.put(new Task("3 Задача высокого приоритета", 1));
        tasks1.add(queue.take());
        queue.put(new Task("4 Задача низкого приоритета", 5));
        tasks1.add(queue.take());
        queue.put(new Task("5 Задача среднего приоритета", 3));

        tasks1.add(queue.take());

        for (Task task : tasks1) {
            System.out.println(task.getPriority());
        }
    }

}
