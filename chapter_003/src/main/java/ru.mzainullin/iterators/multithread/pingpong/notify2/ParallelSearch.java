package ru.mzainullin.iterators.multithread.pingpong.notify2;

import ru.mzainullin.iterators.multithread.pingpong.notify.SimpleBlockingQueue;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 09.10.2018
 */

public class ParallelSearch {

    public static void main(String[] args) throws InterruptedException {

        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();

        queue.offer(15);
        queue.offer(23);
        queue.offer(27);
        queue.offer(29);
        queue.offer(21);

        final Thread consumer = new Thread(
            () -> {
                while (!Thread.currentThread().isInterrupted()) {
                    synchronized (queue) {
                        try {
                            queue.notify();
                            System.out.println(queue.poll());
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                        queue.notify();
                    }
                }
            }
        , "Consumer");

        consumer.start();

        final Thread producer = new Thread(
            () -> {
                for (int index = 0; index != 3; index++) {
                    synchronized (queue) {
                        try {
                            Thread.sleep(500);
                            queue.notify();
                            queue.offer(index);
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        queue.notify();
                    }
                }
                consumer.interrupt();
            }
                , "Producer");

        producer.start();
    }
}
