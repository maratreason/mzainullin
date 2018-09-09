package ru.mzainullin.testsql.crud.services;

import ru.mzainullin.testsql.crud.model.User;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Marat Zainullin
 * @since 09.09.2018
 * @version 1.0
 */
public class ValidateService {

    List<User> users = new CopyOnWriteArrayList();

    /**
     * Метод добавления нового пользователя
     * @param user - новый пользователь
     * @return - добавленного пользователя
     */
    public User add(User user) {
       users.add(user);
       return user;
    }


    /**
     * Метод редактирования пользователя
     * @param name - новое имя
     * @param login - новый логин
     * @param email - новый email
     * @return - список с отредактированным user
     */
    public List<User> update(String name, String login, String email) {
        for (int i = 0; i != users.size(); i++) {
            if ((users.get(i).getName().equals(name)) || (users.get(i).getEmail().equals(email))
                    || (users.get(i).getLogin().equals(login))) {
                users.get(i).setName(name);
                users.get(i).setLogin(login);
                users.get(i).setEmail(email);
            }
        }
        return users;
    }


    /**
     * Метод удаления пользователя
     * @param user - откуда удалять пользователя
     * @return - список без удаленного пользователя
     */
    public List<User> delete(User user) {
        for (int i = 0; i != users.size(); i++) {
            if (users.get(i).equals(user)) {
                users.remove(i);
            }
        }
        return users;
    }


    /**
     * Метод для поиска всех пользователей
     * @return - все пользователи
     */
    public List<User> findAll() {
        users.iterator();
        return users;
    }


    /**
     * Метод для поиска пользователей по их id
     * @param id - id пользователя
     * @return - найденный пользователь
     */
    public User findById(int id) {
        User user = new User();
        for (int i = 0; i != users.size(); i++) {
            if (users.get(i).getId() == id) {
                user = users.get(i);
            }
        }
        return user;
    }

}
