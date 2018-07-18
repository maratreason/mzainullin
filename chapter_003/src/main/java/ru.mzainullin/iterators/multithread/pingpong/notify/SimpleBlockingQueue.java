package ru.mzainullin.iterators.multithread.pingpong.notify;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 11.07.2018
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {

    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();

    public void offer(T value) {
    }

    public T poll() {
        return null;
    }
}
