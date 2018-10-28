package ru.mzainullin.iterators.multithread.pingpong.pool;

import org.junit.Test;
import ru.mzainullin.iterators.multithread.pingpong.notify.SimpleBlockingQueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ThreadPoolTest {

    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();
    private int threadSize;

    @Test
    public void testingWorkMethod() throws InterruptedException {
        int size = Runtime.getRuntime().availableProcessors();
        ThreadPool threadPool = new ThreadPool(size);

        threadPool.work(new Runnable() {
            @Override
            public void run() {
                new Thread().start();
            }
        });

//        assertThat(threadPool.getSize(), is(4));
    }
}