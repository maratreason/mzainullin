package ru.mzainullin.iterators.multithread.pingpong.non_blocking;

import java.util.concurrent.ConcurrentHashMap;

public class CachService {

    public static void main(String[] args) {

        ConcurrentHashMap<Integer, Base> hashMap;

        Thread t1 = new Thread(
                () -> {
                    Base base = new Base(15);
                    hashMap.put(base.getId(), base);
                    System.out.println(base.getId());
                }, "t1"
        );
        t1.start();

        Thread t2 = new Thread(
            () -> {
                Base base = new Base(10);
                base.setId(11);
                hashMap.put(base.getId(), base);
                System.out.println(base.getId());
            }, "t2"
        );
        t2.start();

        Thread t3 = new Thread(
                () -> {
                    Base base = new Base(7);
                    base.getId();
                    hashMap.put(base.getId(), base);
                    System.out.println(base.getId());
                }, "t3"
        );
        t3.start();

    }

}
