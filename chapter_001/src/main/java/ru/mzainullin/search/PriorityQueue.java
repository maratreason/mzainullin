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

        for (int index = 0; index < tasks.size(); index++) {
            if (task.getPriority() <= tasks.get(index).getPriority()) {
                tasks.addFirst(task);
                break;
            } else {
                tasks.add(index, task);
                break;
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }

    public static void main(String[] args) {

        LinkedList<Task> tasks1 = new LinkedList<>();
//        tasks1.add(new Task("1 Задача низкого приоритета", 5));
//        tasks1.add(new Task("2 Задача высокого приоритета", 1));
//        tasks1.add(new Task("3 Задача высокого приоритета", 1));
//        tasks1.add(new Task("4 Задача низкого приоритета", 5));
//        tasks1.add(new Task("5 Задача среднего приоритета", 3));

        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("1 Задача низкого приоритета", 5));
        queue.put(new Task("2 Задача высокого приоритета", 1));
        queue.put(new Task("3 Задача высокого приоритета", 1));
        queue.put(new Task("4 Задача низкого приоритета", 5));
        queue.put(new Task("5 Задача среднего приоритета", 3));

        for (int index = 0; index < tasks1.size(); index++) {
            tasks1 = queue.take();
//            tasks1.add(index, queue.take());
        }

        for (Task task : tasks1) {
            System.out.println(task.getPriority() + " : " + task.getDesc());
        }

    }
}
