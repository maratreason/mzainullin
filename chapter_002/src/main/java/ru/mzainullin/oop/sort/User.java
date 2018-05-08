package ru.mzainullin.oop.sort;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 07.05.2018
 */
public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(){}

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(User o) {
        int a = this.getAge();
        int b = o.getAge();
        return new Integer(a).compareTo(new Integer(b));
    }

}