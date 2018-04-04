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
        System.out.println("--- Новая заявка с getId=" + item.getId() + " ---");
    }


    /**
     * Метод реализует показ всех заявок в хранилище.
     */
    private void showAllItems() {
        System.out.println("--- Показать все заявки ---");
        this.tracker.findAll();
        Item item = new Item();
        System.out.println("--- Все заявки=" + item.getName() + " ---");
    }


    /**
     * Метод редактирует заявку.
     */
    private void editItem() {
        System.out.println("--- Редактировать заявку ---");
        Item item = new Item();
        this.tracker.replace(item.getId(), item);
    }


    /**
     * Метод реализует показ всех заявок в хранилище.
     */
    private void deleteItem() {
        System.out.println("--- Удалить заявку ---");
        Item item = new Item();
        this.tracker.delete(item.getId());
    }


    /**
     * Метод реализует поиск заявки по идентификатору.
     */
    private void findByItemId() {
        System.out.println("--- Найти заявку по идентификатору ---");
        Item item = new Item();
        this.tracker.findById(item.getId());
    }


    /**
     * Метод реализует поиск заявки по имени заявки.
     */
    private void findByItemName() {
        System.out.println("--- Найти заявку по имени заявки ---");
        Item item = new Item();
        this.tracker.findByName(item.getName());
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