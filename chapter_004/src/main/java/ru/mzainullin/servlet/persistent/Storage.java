package ru.mzainullin.servlet.persistent;

import ru.mzainullin.servlet.model.User;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Storage {
    private List<User> users;

    public Storage() {
        this.users = new CopyOnWriteArrayList<>();
    }

    public List<User> getUsers() {
        return this.users;
    }
}
