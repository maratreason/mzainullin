package ru.mzainullin.iterators.multithread.pingpong.pool_email;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorPoolService {

    public static void main(String[] args) {

        CopyOnWriteArrayList<User> users = new CopyOnWriteArrayList<>();
        EmailNotification emailNotification = new EmailNotification();

        ExecutorService pool = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );


        pool.submit(new Runnable() {
            @Override
            public void run() {
                User user = new User("alex", "alex@mail.ru", "Сообщение для Алекса...");
                users.add(user);
                emailNotification.send(user.getUsername(), user.getBody(), user.getEmail());
            }
        });


        pool.submit(new Runnable() {
            @Override
            public void run() {
                User user = new User("sam", "sam@mail.ru", "Сообщение для Сэма");
                users.add(user);
                emailNotification.send(user.getUsername(), user.getBody(), user.getEmail());
            }
        });


        pool.shutdown();

        while (!pool.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        for (User user : users) {
            emailNotification.emailTo(user);
        }

        emailNotification.close();

    }
}