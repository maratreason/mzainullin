package ru.mzainullin.generics;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author Marat Zainullin
 * @since 04.05.2018
 */
public class Generics01 {

    static class User {
        String name;

        User(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            User user = (User) o;
            return name != null ? name.equals(user.name) : user.name == null;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "User{"
                    + "name='" + name + '\''
                    + '}';
        }
    }



    public static void main(String[] args) {

        List<User> users = new ArrayList<User>();
        users.add(new User("petr"));

        // Так можно напрямую добавлять объекты
        users.addAll(Arrays.asList(new User("petr"), new User("ivan")));

        boolean result = users.contains(new User("petr"));
        System.out.println(result);

        for (User user : users) {
            System.out.println(user);
        }

        System.out.println("---");
        System.out.println("Iterator:");

        Iterator<User> it = users.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }


        System.out.println("---");
        System.out.println("Stream API:");

        users.forEach(new Consumer<User>() {
            @Override
            public void accept(User user) {
                System.out.println(user);
            }
        });

        System.out.println("\n Лямбда:");
        users.forEach(user -> System.out.println(user));

        System.out.println("\nЕще короче. Это вызов статического метода:");
        users.forEach(System.out::println);

        System.out.println("\n Map:");

        Map<String, Integer> students = new HashMap<>();
        students.put("petr", 3);
        students.put("ivan", 5);

        System.out.println(students.get("petr"));

        for (String student : students.keySet()) {
            System.out.println(student + " : " + students.get(student));
        }

        for (Integer scope : students.values()) {
            System.out.println(String.format("%s", scope));
        }

    }

}

// Главное перекрыть метод equals() и перекрыть метод hashCode().