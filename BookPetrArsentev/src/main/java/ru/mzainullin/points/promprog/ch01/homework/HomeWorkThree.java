package ru.mzainullin.points.promprog.ch01.homework;

import java.util.Calendar;

public class HomeWorkThree {
    /**
     * Создать приложение, выводящее фамилию разработчика, дату и время
     * получения задания, а также дату и время сдачи задания. Для получения
     * последней даты и времени использовать класс Calendar из пакета
     * java.util.
     */

    private String name;

    public static void main(String[] args) {

        HomeWorkThree home = new HomeWorkThree();
        home.name = "Соболев";
        Calendar calendar = Calendar.getInstance();

        System.out.println("Фамилия: " + home.name);
        System.out.println("Задание получил: " + calendar.getTime().toString());
        System.out.println("Задание выполнил: " + calendar.getTime().toString());
    }

}
