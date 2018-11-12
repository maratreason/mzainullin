package ru.mzainullin.servlet.presentation;

import org.junit.Before;
import org.junit.Test;
import ru.mzainullin.servlet.logic.ValidateService;
import ru.mzainullin.servlet.model.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserCreateServletTest {

    private ValidateService users;

    @Before
    public void beforeTest() {
        this.users = new ValidateService();

        String name = "Sveta";
        String login = "Sveta";
        String email = "sveta@mail.ru";
        String date = "2018/11/12 18:08:41";

        User user = new User(name, login, email, date);

        if (user.getName() != null) {
            this.users.addUser(new User(name, login, email, date));
        }
    }

    @Test
    public void whenAddedUserToCopyOnWriteArrayList() {
        String name = "Alex";
        String login = "alexi";
        String email = "alex@mail.ru";
        String date = "2018/11/12 17:08:41";

        User user = new User(name, login, email, date);

        if (user.getName() != null) {
            this.users.addUser(new User(name, login, email, date));
        }

        /**
         * id=1 - user Sveta
         * id=2 - user Alex
         */
        assertThat(users.findById(1).getName(), is("Sveta"));
        assertThat(users.findById(2).getEmail(), is("alex@mail.ru"));
    }

    @Test
    public void whenUpdatedUser() {

        int id = 1;
        String name = "Alisa";
        String login = "alisa";
        String email = "alisa@mail.ru";
        String date = "2018/11/12 16:08:40";

        System.out.println(String.format("Имя пользователя до изменения: %s", users.findById(1).getName()));

        User user = new User(name, login, email, date);
        user.setId(id);

        if (user.getName() != null) {
            this.users.updateUser(id, user);
        }

        System.out.println(String.format("Имя пользователя после изменения: %s", users.findById(1).getName()));

        assertThat(users.findById(1).getName(), is("Alisa"));
        assertThat(users.findById(1).getCreateDate(), is("2018/11/12 16:08:40"));
    }

    @Test
    public void whenDeleteUser() {
        int id = 1;
        String name = "Alisa";
        String login = "alisa";
        String email = "alisa@mail.ru";
        String date = "2018/11/12 16:08:40";

        User user = new User(name, login, email, date);

        if (user.getName() != null) {
            this.users.addUser(new User(name, login, email, date));
        }

        assertThat(users.getUsers().size(), is(2));
        assertThat(users.findById(1).getName(), is("Sveta"));
        assertThat(users.findById(2).getName(), is("Alisa"));

        /**
         * Удаление пользователя
         */
        this.users.deleteUser(1);

        assertThat(users.getUsers().size(), is(1));
        assertThat(users.findById(1).getName(), is("Alisa"));

    }
}