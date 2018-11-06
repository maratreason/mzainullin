package ru.mzainullin.iterators.multithread.pingpong.pool_email;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailNotification {

    private String subject;
    private String body;
    private String email;
    CopyOnWriteArrayList<User> users;
    ExecutorService pool;

    public EmailNotification() {
        this.pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public EmailNotification(String subject, String body, String email) {
        this.subject = subject;
        this.body = body;
        this.email = email;
    }


    public ExecutorService getThreadPool() {
        return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    /**
     * Метод должен через ExecutorService отправлять почту
     * @param user
     *
     * Метод emailTo должен брать данные пользователя и подставлять в шаблон
    subject = Notification {username} to email {email}.
    body = Add a new event to {username}
     */
    public void emailTo(User user) {
        this.pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("subject = Notification {" + user.getUsername() + "} to email {" + user.getEmail() + "}");
                System.out.println("body = " + user.getBody() + "}");
            }
        });
    }

    /**
     * Метод должен закрыть pool.
     * То есть в классе EmailNotification должно быть поле pool,
     которые используется в emailTo и close().
     */
    public void close() {
        this.pool.shutdown();
    }


    /**
     * Метод должен быть пустой
     * @param subject
     * @param body
     * @param email
     */
    public synchronized void send(String subject, String body, String email) {
        String message = "";
        for (User user : users) {
            if (user.getUsername().equals(subject)) {
                subject = user.getUsername();
            }
            if (user.getEmail().equals(email)) {
                email = user.getEmail();
                message = String.format("От Пользователя: %s, body: %s, email: %s.", subject, body, email);
                user.setBody(message);
                System.out.println(user.getBody());
            }
        }
    }

}