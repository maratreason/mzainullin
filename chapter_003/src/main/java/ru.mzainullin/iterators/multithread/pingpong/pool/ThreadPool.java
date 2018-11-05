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

    public ThreadPool(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start");
        if (tasks.poll() == null) {
            try {
                shutdown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.threads.notify();
        System.out.println(Thread.currentThread().getName() + " end");
    }


    public void work(Runnable job) throws InterruptedException {
        for (int i = 1; i < numberOfThreads; i++) {
            this.tasks.offer(job);
        }
    }


    public void shutdown() throws InterruptedException {
        this.threads.wait();
    }


    public static void main(String[] args) throws InterruptedException {

        int size = Runtime.getRuntime().availableProcessors();
        ThreadPool threadPool = new ThreadPool(size);

        for (int index = 0; index < 10; index++) {

            Thread thread = new Thread() {
                public void run() {
                    try {
                        System.out.println("Поток " + " добавлен. Имя потока: " + this.getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();

            if (index < size) {
                threadPool.work(thread);
            } else {
                Thread.sleep(3_00);
            }


            new Thread() {
                public void run() {
                    try {
                        Thread.sleep(3_00);
                        // Извлечение одного потока
                        System.out.println("Извлеченный поток " + threadPool.tasks.poll());

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

        }
        threadPool.shutdown();


    }
}
