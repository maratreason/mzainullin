package ru.mzainullin.points.promprog.ch01;

public class Runner {
    public static void main(String[] args) {
        User user = new User();
        user.numericCode = 71;
        user.setPassword("pass");
        UserView.welcome(user);
    }
}
