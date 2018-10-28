package ru.mzainullin.iterators.multithread.pingpong.pool;

import ru.mzainullin.iterators.multithread.pingpong.notify.SimpleBlockingQueue;

public class RunnablePoolThread extends Thread {
    private SimpleBlockingQueue<Runnable> currentTasks;

    public RunnablePoolThread(SimpleBlockingQueue<Runnable> tasks) {
        currentTasks = tasks;
    }

    public void run() {
        while (true) {
            try {
                currentTasks.poll().run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
