package ru.mzainullin.servlet.persistent;

import ru.mzainullin.servlet.model.User;

import java.util.List;

public interface Store {
    void add(User user);
    void update(int id, User user);
    void delete(int id);
    User findById(int id);
    List<User> findAll();
}
