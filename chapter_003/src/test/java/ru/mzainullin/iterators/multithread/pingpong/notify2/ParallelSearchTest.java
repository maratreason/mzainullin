package ru.mzainullin.iterators.multithread.pingpong.notify2;

import ru.mzainullin.iterators.multithread.pingpong.notify.SimpleBlockingQueue;
import org.junit.Test;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ParallelSearchTest {
    @Test
    public void whenFetchAllThenGetIt() throws InterruptedException {
        final CopyOnWriteArrayList<Integer> buffer = new CopyOnWriteArrayList<>();
        final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();

        Thread producer = new Thread(
                () -> {
                    IntStream.range(0, 6).forEach(
                            queue::offer
                    );
                }
        );
        producer.start();

        Thread consumer = new Thread(
                () -> {
                    while (!queue.isEmpty() || !Thread.currentThread().isInterrupted()) {
                        try {
                            Integer result = queue.poll();
                            if (result != null) {
                                buffer.add(result);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                    }
                }
        );
        consumer.start();

        producer.join();
        consumer.interrupt();
        consumer.join();

        assertThat(buffer, is(Arrays.asList(0, 1, 2, 3, 4, 5)));
    }
}