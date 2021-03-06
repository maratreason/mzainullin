package ru.mzainullin.iterators.multithread.pingpong.producer_consumer;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Producer {
    private final LinkedBlockingQueue<Integer> queue;
    private final ExecutorService producers;
    private final AtomicBoolean stop;

    public Producer(LinkedBlockingQueue<Integer> queue, final AtomicBoolean stop) {
        this.producers = Executors.newFixedThreadPool(3);
        this.queue = queue;
        this.stop = stop;
    }

    void producing() {
        for (int i = 0; i < 3; i++) {
            final Thread producer = new Thread(new Runnable() {
                private final Random random = new Random();
                @Override
                public void run() {
                    while (!stop.get()) {
                        queue.add(this.random.nextInt());
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.err.println("===============================");
                }
            });

            this.producers.submit(producer);
        }
    }
}
