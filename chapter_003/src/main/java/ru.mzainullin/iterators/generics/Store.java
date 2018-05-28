package ru.mzainullin.iterators.generics;

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
    void add(T model);

    /**
     * Метод для замены одной модели на другую
     * @param id - id модели для замены
     * @param model - новая модель.
     */
    boolean replace(String id, T model);

    /**
     * Метод удаления модели
     * @param id - id удаляемой модели
     */
    boolean delete(String id);

    /**
     * Метод поиска объектов по id
     * @param id - id объекта
     */
    T findById(String id);
}