package ru.mzainullin.iterators.multithread.pingpong.pool_email;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorPoolService {

    public static void main(String[] args) {

        String body = "Здесь может быть любое сообщение от пользователя";

        CopyOnWriteArrayList<User> users = new CopyOnWriteArrayList<>();

        EmailNotification emailNotification = new EmailNotification();

        ExecutorService pool = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );

//        pool.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Execute " + Thread.currentThread().getName());
//            }
//        });
//
//        pool.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Execute " + Thread.currentThread().getName());
//            }
//        });

//        pool.shutdown();



        pool.submit(new Runnable() {
            @Override
            public void run() {
                User user = new User("alex", "alex@mail.ru", body);
                users.add(user);
            }
        });

        pool.submit(new Runnable() {
            @Override
            public void run() {
                User user = new User("sam", "sam@mail.ru", "Сообщение для Сэма");
                users.add(user);
            }
        });

        pool.submit(new Runnable() {
            @Override
            public void run() {
                for (User user : users) {
                    emailNotification.send(user.getUsername(), body, user.getEmail());
                }
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


        System.out.println("Execute " + Thread.currentThread().getName());

        for (User user : users) {
            emailNotification.emailTo(user);
        }

        emailNotification.close();

    }

    //---------------------------------------------------------------------

    /**
     * Через ExecutorService создайте задачу, которая будет создать данные для пользователя и передавать их в метод send.
     */



}

