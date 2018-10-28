package ru.mzainullin.iterators.multithread.pingpong.pool;

import ru.mzainullin.iterators.multithread.pingpong.notify.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool implements Runnable {

    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();
    private int numberOfThreads;

    public ThreadPool() {}

    public ThreadPool(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }

    @Override
    public void run() {
        System.out.println("start: " + numberOfThreads);
    }

    public void work(Runnable job) {
        this.tasks.offer(job);
    }

    public void shutdown() {

    }

    public SimpleBlockingQueue<Runnable> getTasks() {
        return this.tasks;
    }

    public static void main(String[] args) {

        SimpleBlockingQueue<Runnable> tasks = new ThreadPool().getTasks();

        for (int index = 0; index < 5; index++) {
            tasks.offer(new ThreadPool(index));
        }

        ExecutorService exec = Executors.newFixedThreadPool(4);

        for (int index = 0; index < 5; index++) {
            exec.submit(new ThreadPool(index));
        }

        exec.shutdown();
    }
}
