package ru.mzainullin.iterators.multithread.pingpong.notify;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 11.07.2018
 */
public class ProducerCustomer {

    private final Object lock = new Object();
    private boolean blockCustomer = true; // thread stack

    public void doSomething() throws InterruptedException {
        Object lock = new Object();
        synchronized (this.lock) {
            while (this.blockCustomer) {
                System.out.println(String.format("%s wait", Thread.currentThread().getId()));
                lock.wait();
            }
            System.out.println(String.format("%s userful work", Thread.currentThread().getId()));
            // TODO some useful things
        }
    }

    public void changeBlock(boolean enable) {
        synchronized (this.lock) {
            System.out.println(String.format("%s enable", Thread.currentThread().getId()));
            this.blockCustomer = enable;
            this.lock.notify();
        }
    }

    public static void main(String[] args) {

        final ProducerCustomer blockingWork = new ProducerCustomer();

        // Producer
        Thread producer = new Thread() {
            @Override
            public void run() {
                // разбудить блок
                blockingWork.changeBlock(false);
            }
        };

        // Customer
        Thread customer = new Thread() {
            @Override
            public void run() {
                try {
                    // разбудить блок
                    blockingWork.doSomething();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        producer.start();
        customer.start();

    }
}
