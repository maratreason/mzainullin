package ru.mzainullin.OOP.start;

import ru.mzainullin.OOP.models.Item;

import java.util.*;

/**
 * @author Marat Zainullin
 * @version $Id$
 * @since 0.1
 */
public class Tracker {

    private final Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод реализаущий замену заявки по id
     * @param item новая заявка
     * @param id = номер id заявки
     */
    public void replace(String id, Item item) {
        if(this.items[this.position].getId().equals(id)) {
            item.setId(id);
        }
    }

    /**
     * Метод реализаущий удаление заявки по id
     * @param id
     */
    public void delete(String id){
        if(this.items[this.position].getId().equals(id)) {
            this.items[this.position] = null;
        }
    }

    /**
     * Метод реализующий поиск всех имеющихся заявок
     * @return коллекция заявок
     */
    public Item[] findAll(){
        Item[] result = new Item[position];
        for(int index = 0; index != result.length; index++) {
            if(result != null) {
                result[position].getName();
            }
        }
        return result;
    }

    /**
     * Метод реализующий поиск всех заявок по имени
     * @return текущее имя указанное в поиске
     */
    public Item[] findByName(String key){
        Item[] result = new Item[position];
        for(int index = 0; index != result.length; index++) {
            if(result[index] != null && result[index].getName().equals(key)) {
                System.out.println("Есть такое имя " + result[index].getName());
            } else {
                System.out.println("Нет такого имени");
            }
        }
        return result;
    }

    /**
     * Метод реализаущий поиск по идентификатору
     * @return result
     */
    protected Item findById(String id) {
        Item result = null;
        for(Item item : items) {
            if(item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    public Item[] getAll() {
        Item[] result = new Item[position];
        for(int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

}
