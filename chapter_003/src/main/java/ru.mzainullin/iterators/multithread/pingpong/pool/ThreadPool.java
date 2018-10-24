package ru.mzainullin.iterators.multithread.pingpong.pool;

import ru.mzainullin.iterators.multithread.pingpong.notify.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();
    private int threadSize;

    public ThreadPool(int size) {
        this.threadSize = size;
    }

    public void work(Runnable job) throws InterruptedException {

        synchronized (tasks) {
            if (job != null) {
                this.threads.add(new Thread(job));
                for (int i = 0; i < threads.size(); i++) {
                    this.tasks.offer(threads.get(i));
                }
            } else {
                shutdown();
            }
            this.tasks.notify();
        }
    }

    @Override
    public String toString() {
        return "ThreadPool{" +
                "threadSize=" + threadSize +
                '}';
    }

    public void shutdown() {
        synchronized (tasks) {
            for (int i = 0; i < threads.size(); i++) {
                this.threads.get(i).interrupt();
            }
        }
    }

    public static void main(String[] args) {
        int size = Runtime.getRuntime().availableProcessors();
        ThreadPool threadPool = new ThreadPool(size);

        for (int i = 0; i < size; i++) {
            System.out.println("ThreadPool: " + i);
        }

        System.out.println(threadPool.toString());
    }
}
