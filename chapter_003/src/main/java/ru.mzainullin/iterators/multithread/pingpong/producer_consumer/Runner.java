package ru.mzainullin.iterators.multithread.pingpong.producer_consumer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Runner {
    private final AtomicBoolean stop;
    private final LinkedBlockingQueue<Integer> queue;

    private Runner() {
        this.stop = new AtomicBoolean(false);
        this.queue = new LinkedBlockingQueue<>();
    }

    public void start() {
        final Consumer consumer = new Consumer(queue, stop);
        final Producer producer = new Producer(queue, stop);
        producer.producing();
        consumer.consuming();

        // Через 10 секунд поменяется флаг на true
        // и все процессы остановятся.
        // Чтобы не было переполнения стека вывода.
        final Timer timer = new Timer();
        timer.schedule(new Stopper(), 10000);
    }

    private class Stopper extends TimerTask {
        @Override
        public void run() {
            stop.set(true);
        }
    }

    public static void main(String[] args) {
        new Runner().start();
    }
}
