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
//        if (task.getPriority() == 5) {
//            this.tasks.addLast(task);
//        } else if (task.getPriority() == 1) {
//            this.tasks.addFirst(task);
//        } else if (task.getPriority() == 3) {
//            this.tasks.add(task);
//        }

        for (int index = 0; index < this.tasks.size(); index++) {
            if (task.getPriority() <= tasks.get(index).getPriority()) {
                this.tasks.add(index, task);
                break;
            }
        }
        this.tasks.add(task);
    }

    public Task take() {
        return this.tasks.poll();
    }

    public static void main(String[] args) {

        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("1 Задача низкого приоритета", 5));
        queue.put(new Task("2 Задача высокого приоритета", 1));
        queue.put(new Task("3 Задача высокого приоритета", 1));
        queue.put(new Task("4 Задача низкого приоритета", 5));
        queue.put(new Task("5 Задача среднего приоритета", 3));

    }

}
