package ru.mzainullin.bank;

import java.util.Objects;

/**
 * @author Marat Zainulin
 * @version 1.0
 * @sicne 15.05.2018
 */
public class User {

    private String name;

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }
}
