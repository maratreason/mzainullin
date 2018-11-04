package ru.mzainullin.servlet.logic;

import ru.mzainullin.servlet.model.User;
import ru.mzainullin.servlet.persistent.Storage;
import java.util.List;

public class ValidateService implements Validate {

    /**
     * Список пользователей
     */
    private List<User> users = new Storage().getUsers();


    /**
     * Добавление пользователя
     * @param user - добавленный пользователь
     */
    public void addUser(User user) {
        this.users.add(user);
    }


    /**
     * Удаление пользователя
     * @param id - id
     */
    public void deleteUser(int id) {
        for (int i = 0; i != this.users.size(); i++) {
            if (this.users.get(i).getId() == id) {
                this.users.remove(i);
                break;
            }
            System.out.println("Такого пользователя не существует");
        }
    }


    /**
     * Обновление пользователя
     * @param id - id
     * @param user - новый пользователь
     */
    public void updateUser(int id, User user) {
        for (int i = 0; i != this.users.size(); i++) {
            if (this.users.get(i).getId() == id) {
                this.users.get(i).setId(id);
                this.users.get(i).setName(user.getName());
                this.users.get(i).setLogin(user.getLogin());
                this.users.get(i).setEmail(user.getEmail());
                this.users.get(i).setCreateDate(user.getCreateDate());
                break;
            }
            System.out.println("Такого пользователя не существует");
        }
    }


    /**
     * Выборка всех пользователей
     * @return список
     */
    public List<User> findAll() {
        return this.users;
    }


    /**
     * Поиск пользователей по id
     * @param id - id
     * @return - пользователь
     */
    public User findById(int id) {
        User user = this.users.get(0);
        for (int i = 0; i != this.users.size(); i++) {
            if (this.users.get(i).getId() == id) {
                user = this.users.get(i);
            }
        }
        return user;
    }


    public List<User> getUsers() {
        return this.users;
    }

    public static ValidateService getInstance() {
        return getInstance();
    }

}
