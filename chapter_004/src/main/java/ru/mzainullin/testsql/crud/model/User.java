package ru.mzainullin.testsql.crud.model;

import java.util.Date;

/**
 * @author Marat Zainullin
 * @since 09.09.2018
 * @version 1.0
 */
public class User {



    private int id = 0;
    private String name;
    private String login;
    private String email;
    private Date createDate;

    public User() {}

    public User(String name, String login, String email, Date createDate) {
        this.id = id++;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
