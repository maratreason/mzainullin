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

    /**
     * Объект для блокировки потоков.
     */
    private final BlockThread blockThread = new BlockThread();

    @GuardedBy("this")
    private final Queue<T> queue = new LinkedList<>();

    /**
     * Метод добавления элемента в конец очереди
     * @param value объект
     */
    public void offer(T value) {
        try {
            blockThread.lock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.queue.add(value);
        blockThread.unlock();
    }

    /**
     * Метод получения элемента из коллекции
     *
     * @return потокобезопасная очередь
     */
//    public T poll() {
//        if (queue.isEmpty()) {
//            try {
//                blockThread.lock();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        return this.queue.poll();
//    }

    public T poll() {
        T result = null;
        if (!queue.isEmpty()) {
            try {
                blockThread.lock();
                result = this.queue.poll();
                blockThread.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * Метод измерения размера коллекции
     *
     * @return размер.
     */
    public int size() {
        synchronized(this.queue) {
            return this.queue.size();
        }
    }

    /**
     * Метод получения коллекции
     *
     * @return текущая коллекция.
     */
    public Queue getQueue() {
        synchronized(this.queue) {
            return this.queue;
        }
    }

    /**
     * Метод проверяющий коллекцию на пустоту.
     *
     * @return true или false
     */
    public boolean isEmpty() {
        synchronized(this.queue) {
            return this.queue.isEmpty();
        }
    }
}
