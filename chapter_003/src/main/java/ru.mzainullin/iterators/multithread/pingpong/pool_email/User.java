package ru.mzainullin.iterators.multithread.pingpong.pool_email;

public class User {
    private String username;
    private String email;
    private String body;

    public User(String username, String email, String body) {
        this.username = username;
        this.email = email;
        this.body = body;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}