package ru.mzainullin.iterators.multithread.pingpong.pool_email;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorPoolService {

    public static void main(String[] args) throws InterruptedException {

        CopyOnWriteArrayList<User> users = new CopyOnWriteArrayList<User>() {
            {
                add(new User("misha", "misha@mail.ru", "Сообщение для Михаила..."));
                add(new User("chris", "chris@mail.ru", "Сообщение для Криса..."));
                add(new User("tom", "tom@mail.ru", "Сообщение для Тома..."));
            }
        };
        EmailNotification emailNotification = new EmailNotification();

        ExecutorService pool = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );



        pool.submit(new Runnable() {
            @Override
            public void run() {
                emailNotification.send("chris", "такое то сообщение...", "tom@mail.ru");
            }
        });


        pool.submit(new Runnable() {
            @Override
            public void run() {
                for (User user : users) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    emailNotification.emailTo(user);
                }
            }
        });


        while (!pool.isTerminated()) {
            try {
                Thread.sleep(100);
                pool.shutdown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        emailNotification.close();

    }
}