package ru.mzainullin.iterators.multithread.pingpong.notify;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 11.07.2018
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {

    private final BlockThread blockThread = new BlockThread();

    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();

    public void offer(T value) {
        try {
            blockThread.lock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.queue.add(value);
        blockThread.unlock();
    }

    public T poll() {
        if (queue.isEmpty()) {
            try {
                blockThread.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.queue.poll();
    }

    public int size() {
        return this.queue.size();
    }

    public Queue getQueue() {
        return this.queue;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
