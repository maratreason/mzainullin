package ru.mzainullin.iterators.multithread.pingpong.producer_consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

class Consumer {
    private final LinkedBlockingQueue<Integer> queue;
    private final ExecutorService consumers;
    private final AtomicBoolean stop;

    public Consumer(LinkedBlockingQueue<Integer> queue, final AtomicBoolean stop) {
        this.consumers = Executors.newFixedThreadPool(3);
        this.queue = queue;
        this.stop = stop;
    }

    void consuming() {
        for (int i = 0; i < 3; i++) {
            final Thread consumer = new Thread(new Runnable() {

                @Override
                public void run() {
                    while (!stop.get()) {
                        try {
                            // Если в течении 100 миллисекунд не оказывается никакого действия,
                            // то все останавливается.
                            final Integer poll = queue.poll(1000, TimeUnit.MILLISECONDS);
                            final Integer result = poll * 2;
                            System.out.println("Consumer: " + result);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            this.consumers.submit(consumer);
            System.out.println("Thread: " + consumer.getId());
        }
    }
}
