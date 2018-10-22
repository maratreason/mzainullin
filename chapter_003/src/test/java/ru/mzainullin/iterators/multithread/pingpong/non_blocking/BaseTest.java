package ru.mzainullin.iterators.multithread.pingpong.non_blocking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BaseTest {

    ConcurrentHashMap<Integer, Base> hashMap = new ConcurrentHashMap<Integer, Base>();

    @Test
    public void whenThrowException() throws InterruptedException {
        AtomicReference<Exception> ex = new AtomicReference<>();
        Thread thread = new Thread(
                () -> {
                    try {
                        throw new RuntimeException("Throw Exception in Thread");
                    } catch (Exception e) {
                        ex.set(e);
                    }
                }
        );
        thread.start();
        thread.join();
        Assert.assertThat(ex.get().getMessage(), is("Throw Exception in Thread"));
    }


    @Test
    public void whenAddedNewBaseOnCollection() throws InterruptedException {

        Base base1 = new Base(1);
        Base base2 = new Base(2);
        Base base3 = new Base(5);

        Thread t1 = new Thread(
                () -> {

                    hashMap.put(1, base1);
                    System.out.println(base1.getId());
                }, "t1"
        );

        Thread t2 = new Thread(
                () -> {
                    base2.setId(14);
                    hashMap.put(2, base2);
                    System.out.println(base2.getId());
                }, "t2"
        );

        Thread t3 = new Thread(
                () -> {
                    hashMap.put(3, base3);
                    System.out.println(base3.getId());
                }, "t3"
        );

        t1.start();
        t2.start();
        t3.start();

//        Assert.assertThat(hashMap.get(0).getId(), is(1));
//        Assert.assertThat(hashMap.get(1).getId(), is(14));
//        Assert.assertThat(hashMap.get(2).getId(), is(5));
        Assert.assertThat(hashMap.keySet(), is(Arrays.asList(1, 2, 3)));
    }

}