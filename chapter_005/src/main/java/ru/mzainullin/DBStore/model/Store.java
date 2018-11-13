package ru.mzainullin.DBStore.model;

import java.util.List;

/**
 * @author Marat Zainullin
 * @since 25.05.2018
 * @param <T> - тип ограниченный Base
 */
public interface Store<T extends Base> {

    /**
     * Метод для добавления модели
     * @param model - модель для добавления
     */
    User add(T model);

    /**
     * Метод для замены одной модели на другую
     * @param id - id модели для замены
     * @param model - новая модель.
     */
    void update(String id, User model);

    /**
     * Метод удаления модели
     * @param id - id удаляемой модели
     */
    String delete(String id);

    /**
     * Метод поиска объектов по id
     * @param id - id объекта
     */
    String findById(String id);

    /**
     * Метод получения всех объектов
     * @return - список объектов
     */
    List<User> findAll();
}