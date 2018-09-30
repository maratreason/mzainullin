package ru.mzainullin.servlet.logic;

import ru.mzainullin.servlet.model.User;
import ru.mzainullin.servlet.persistent.Storage;
import java.util.List;

public class Service {

    private List<User> users = new Storage().getUsers();

    public List<User> getUsers() {
        return this.users;
    }

    public void addUser(User user) {
//        for(User us : users) {
//            if (!(user.getId() == us.getId())) {
                this.users.add(user);
//                break;
//            }
//            System.out.println("Пользователь с таким id уже существует");
//        }
    }

    public void deleteUser(int id) {
        for(int i = 0; i != this.users.size(); i++) {
            if (this.users.get(i).getId() == id) {
                this.users.remove(i);
                break;
            }
            System.out.println("Такого пользователя не существует");
        }
    }

    public void updateUser(int id, User user) {
        for(int i = 0; i != this.users.size(); i++) {
            if (this.users.get(i).getId() == id) {
                this.users.remove(i);
                this.users.add(user);
                break;
            }
            System.out.println("Такого пользователя не существует");
        }
    }

}
