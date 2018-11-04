package ru.mzainullin.servlet.logic;

import ru.mzainullin.servlet.model.User;

import java.util.List;

public interface Validate {

    /**
     * Добавление пользователя
     * @param user - добавленный пользователь
     */
    void addUser(User user);

    /**
     * Удаление пользователя
     * @param id - id
     */
    void deleteUser(int id);

    /**
     * Обновление пользователя
     * @param id - id
     * @param user - новый пользователь
     */
    void updateUser(int id, User user);

    /**
     * Выборка всех пользователей
     */
    List<User> findAll();

    /**
     * Поиск пользователей по id
     * @param id - id
     */
    User findById(int id);
}
