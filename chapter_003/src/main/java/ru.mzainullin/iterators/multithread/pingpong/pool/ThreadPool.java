package ru.mzainullin.iterators.multithread.pingpong.pool;

import ru.mzainullin.iterators.multithread.pingpong.notify.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;

public class ThreadPool implements Runnable {

    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();
    private int numberOfThreads;
    private volatile boolean isRunning = true;


    public ThreadPool(int numberOfThreads) {
        this.numberOfThreads = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(new RunnablePoolThread()).start();
        }
    }


    @Override
    public void run() {
        while (isRunning) {
            Runnable nextTask = tasks.poll();
            if (nextTask != null) {
                nextTask.run();
            }
        }
    }


    public void work(Runnable job) throws InterruptedException {
        if (isRunning) {
            this.tasks.offer(job);
        }
    }


    public void shutdown() throws InterruptedException {
        isRunning = false;
    }


    private final class RunnablePoolThread implements Runnable {
        @Override
        public void run() {
            while (isRunning) {
                Runnable nextTask = tasks.poll();
                if (nextTask != null) {
                    nextTask.run();

                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {

        int size = Runtime.getRuntime().availableProcessors();
        ThreadPool threadPool = new ThreadPool(size);

        final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();

        for (int i = 0; i < 15; i++) {

                Thread.sleep(3_00);
                threadPool.work(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            tasks.offer(Thread.currentThread());
                            System.out.println("Поток " + Thread.currentThread().getName() + " добавлен");
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                });


            new Thread() {
                public void run() {
                    try {
                        Thread.sleep(3_00);
                        // Извлечение одного
                        Runnable s = tasks.poll();
                        System.out.println("Поток извлечен " + s);
                        System.out.println("\t--- Количество потоков в пуле " + tasks.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

        }

        Thread.sleep(2_000);
        threadPool.shutdown();
    }
}

/**
 1. Инициализация пула должна быть по количеству ядер в системе.
 int size = Runtime.getRuntime().availableProcessors()
 В каждую нить передается блокирующая очередь tasks.
 Количество нитей всегда одинаковое и равно size.
 В методе run мы должны получить задачу их очереди tasks.
 tasks - это блокирующая очередь. Если в очереди нет элементов, то нить переводиться в состоянии waiting.
 Когда приходит новая задача, всем нитям в состоянии waiting посылается сигнал проснуться и начать работу.

 2. Создать метод work(Runnable job). - этот метод должен добавлять задачи в блокирующую очередь tasks.
 */