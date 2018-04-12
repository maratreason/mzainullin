package ru.mzainullin.oop.start;

import ru.mzainullin.oop.models.Item;
import ru.mzainullin.oop.models.Task;

import java.util.Arrays;

/**
 * @author Marat Zainullin (maratreason@mail.ru)
 * @version 1.0
 * @since 18.03.2018
 */
public class StartUI {

    //Константа меню для добавления новой заявки.
    private static final String ADD = "0";

    //Константа меню для показа всех заявок.
    private static final String SHOW_ALL = "1";

    //Константа меню для редактирования заявок.
    private static final String EDIT = "2";

    //Константа меню для показа всех заявок.
    private static final String DELETE = "3";

    //Константа меню для показа всех заявок.
    private static final String FIND_BY_ID = "4";

    //Константа меню для показа всех заявок.
    private static final String FIND_BY_NAME = "5";

    //Константа для выхода из цикла.
    private static final String EXIT = "6";

    //Получение данных от пользователя.
    private final Input input;

    //Хранилище заявок.
    private final Tracker tracker;

    //Позиция текущих заявок.
    private int position = 0;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.tracker = tracker;
        this.input = input;
    }


    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Выбоерите пункт меню:");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW_ALL.equals(answer)) {
                this.showAllItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_BY_ID.equals(answer)) {
                this.findByItemId();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.findByItemName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }


    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("--- Добавление новой заявки ---");
        String name = this.input.ask("Введите имя заявки");
        String desc = this.input.ask("Введите описание заявки");

        Item item = new Item(name, desc);
        this.tracker.add(item);
        position++;
        System.out.println("--- Новая заявка с getId=" + item.getId() + " ---");
    }


    /**
     * Метод реализует показ всех заявок в хранилище.
     */
    private void showAllItems() {
        System.out.println("--- Показать все заявки ---");
        for (Item item : tracker.findAll()) {
            System.out.print("ID заявки = " + item.getId().toString());
            System.out.print(", Имя заявки = " + item.getName().toString());
            System.out.println(", Описание заявки = " + item.getDescription().toString());
        }
    }


    /**
     * Метод редактирует заявку.
     */
    private void editItem() {
        System.out.println("--- Редактировать заявку ---");

        for (Item item : tracker.findAll()) {

            System.out.println(item.getName());
            System.out.println("Выберите заявку...");

            String oldName = this.input.ask("Укажите имя существующей заявки");

            if(item.getName().equals(oldName)) {

                String newName = this.input.ask("Введите новое имя заявки");
                String newDesc = this.input.ask("Введите новое описание для заявки");

                item.name = newName;
                item.description = newDesc;

                tracker.replace(item.getId(), item);
                break;

            }
            System.out.println("--- Заявка изменена. ---");
        }
    }


    /**
     * Метод реализует удаление текущей заявки.
     */
    private void deleteItem() {
        System.out.println("--- Удалить заявку ---");

        String deleteId = this.input.ask("Введите номер ID для удаления");
        for (Item item : tracker.findAll()) {
            if (item.getId().equals(deleteId)) {
                tracker.delete(item.getId());
                System.out.println("--- Заявка удалена ---");
            }
        }
    }


    /**
     * Метод реализует поиск заявки по идентификатору.
     */
    private void findByItemId() {
        System.out.println("--- Найти заявку по идентификатору ---");

        String expectId = this.input.ask("Введите id");
        for (Item item : tracker.findAll()) {
            if (item.getId().equals(expectId)) {
                System.out.println("Заявка с id: " + item.getId());
                System.out.print("Имя заявки = " + item.getName().toString());
                System.out.println(", Описание заявки = " + item.getDescription().toString());
                break;
            } else {
                System.out.println("Заявки с таким id не существует...");
            }
        }
    }


    /**
     * Метод реализует поиск заявки по имени заявки.
     */
    private void findByItemName() {
        System.out.println("--- Найти заявку по имени заявки ---");

        String expectName = this.input.ask("Введите имя");

        for(Item item : tracker.findAll()) {
            this.tracker.findByName(expectName);
            if(item.getName().equals(expectName)) {
                System.out.println("Заявка с id: " + item.getId());
                System.out.print("Имя заявки = " + item.getName().toString());
                System.out.println(", Описание заявки = " + item.getDescription().toString());
                break;
            } else {
                System.out.println("Заявки с таким именем не существует...");
                break;
            }
        }
    }


    private void showMenu() {
        System.out.println("Меню");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

}