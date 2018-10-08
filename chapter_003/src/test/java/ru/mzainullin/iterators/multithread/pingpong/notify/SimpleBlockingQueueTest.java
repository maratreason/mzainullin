package ru.mzainullin.iterators.multithread.pingpong.notify;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleBlockingQueueTest {

    SimpleBlockingQueue<Integer> blockingQueue = new SimpleBlockingQueue<>();

    @Before
    public void setup() {
        blockingQueue.offer(18);
        blockingQueue.offer(19);
        blockingQueue.offer(23);
        blockingQueue.offer(25);
    }

    @Test
    public void whenOfferToBlockingQueueAndShowResult() {
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                blockingQueue.offer(1);
                blockingQueue.offer(2);
                blockingQueue.offer(3);
            }
        });

        Thread customer = new Thread(new Runnable() {
            @Override
            public void run() {
                blockingQueue.offer(4);
                blockingQueue.offer(5);
                blockingQueue.offer(6);
            }
        });

        producer.start();
        customer.start();

        for (Object num : blockingQueue.getQueue()) {
            System.out.println("thread: " + num);
        }

        assertThat(blockingQueue.getQueue(), is(Arrays.asList(18, 19, 23, 25, 1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void whenPollToBlockingQueueAndShowResult() {
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                blockingQueue.poll();
            }
        });

        Thread customer = new Thread(new Runnable() {
            @Override
            public void run() {
                blockingQueue.poll();
            }
        });

        producer.start();
        customer.start();

        for (Object num : blockingQueue.getQueue()) {
            System.out.println("thread: " + num);
        }

        assertThat(blockingQueue.getQueue(), is(Arrays.asList(23, 25)));
    }
}