package ru.mzainullin.points.promprog.ch01;

public class UserView {
    public static void welcome(User obj) {
        System.out.printf("Привет! Введен код: %d, пароль: %s",
                obj.getNumericCode(), obj.getPassword());
    }
}
