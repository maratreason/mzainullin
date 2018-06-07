package ru.mzainullin.oop.start;

import ru.mzainullin.oop.models.Item;

import java.sql.PreparedStatement;
import java.util.*;

/**
 * @author Marat Zainullin
 * @version 1.2
 * @since 07.05.2018
 */
public class Tracker implements AutoCloseable {

    private int position = 0;
    private static final Random RN = new Random();
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
    private List<Item> items = new ArrayList<>();;


    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        return item;
    }


    /**
     * Новый метод перезаписи заявки по id
     * @param newId - перезапись
     */
    public void edit(Item newId) {
        for (int index = 0; index != items.size(); index++) {
            Item item = items.get(index);
            if (item != null && item.getId().equals(newId.getId())) {
                items.set(index, newId);
                break;
            }
        }
    }


    /**
     * Метод реализаущий замену заявки по id
     * @param item новая заявка
     * @param id = номер id заявки
     */
    public void replace(String id, Item item) {
        for (int index = 0; index != this.position; index++) {
            if (items.get(index).getId().equals(id)) {
                items.get(index).setId(id);
                break;
            }
        }
    }


    /**
     * Метод реализаущий удаление заявки по id
     * @param id
     */
    public void delete(String id) {
        for (int index = 0; index != items.size() - 1; index++) {
            if (items.get(index).getId().equals(id)) {
                items.remove(index);
                break;
            }
        }
    }


    /**
     * Метод реализующий поиск всех имеющихся заявок
     * @return коллекция заявок
     */
    public List<Item> findAll() {
        List<Item> showItems = new ArrayList<>();
        for (Item item : items) {
            showItems.add(item);
//            System.out.println(String.format("%s, %s", item.getName(), item.getDescription()));
        }
        return showItems;
    }


    /**
     * Метод реализующий поиск всех заявок по имени
     * @return текущее имя указанное в поиске
     */
    public List<Item> findByName(String key) {
        List<Item> item = new ArrayList<>();
        for (int index = 0; index != item.size(); index++) {
            if (item.get(index) != null && item.get(index).getName().equals(key)) {
                item.get(index);
            }
        }
        return item;
    }


    /**
     * Метод реализаущий поиск по идентификатору
     * @return result
     */
    public Item findById(String id) {
        Item item = new Item();
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index) != null && items.get(index).getId().equals(id)) {
                item = items.get(index);
                break;
            }
        }
        return item;
    }

    @Override
    public void close() throws Exception {

    }

}
