package ru.mzainullin.iterators.multithread.pingpong.notify;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 08.10.2018
 */
public class BlockThread {
    private boolean isLocked = false;

    public void lock() throws InterruptedException {
        synchronized (this) {
            while (isLocked) {
                wait();
            }
        }
    }

    public void unlock() {
        synchronized (this) {
            isLocked = false;
            notify();
        }
    }
}
