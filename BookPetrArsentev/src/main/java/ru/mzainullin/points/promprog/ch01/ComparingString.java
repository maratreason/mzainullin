package ru.mzainullin.points.promprog.ch01;

public class ComparingString {
    public static void main(String[] args) {
        String s1, s2;
        s1 = "Java";
        s2 = s1;
        System.out.println("Сравнение ссылок " + (s1 == s2)); // true

        //Создаем новый объект добавлением символа
        s1 += '2';
        // Создание нового объекта копированием
        s2 = new String(s1);
        System.out.println("Сравнение ссылок " + (s1 == s2)); // false

        System.out.println("Сравнение значений " + s1.equals(s2)); // true
    }
}
