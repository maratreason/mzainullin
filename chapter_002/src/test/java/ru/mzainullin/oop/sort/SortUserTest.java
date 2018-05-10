package ru.mzainullin.oop.sort;

import org.junit.Test;
import ru.mzainullin.oop.sort.SortUser;
import ru.mzainullin.oop.sort.User;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 07.05.2018
 */
public class SortUserTest {

    @Test
    public void whenPutListAndTakeSortedList() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>();
        TreeSet<User> newSet = new TreeSet<>();

        users.addAll(
                Arrays.asList(
                        new User("Filipp", 25),
                        new User ("Zed", 15),
                        new User("Boris", 47),
                        new User("Asteriks", 34)
                )
        );
        sortUser.sort(users, newSet);
        newSet.addAll(users);

        assertThat(sortUser.sort(users, newSet).toString(), is(newSet.toString()));

        for(User s : newSet) {
            System.out.println(String.format("%s %s",s.getName(), s.getAge()));
        }
    }


    @Test
    public void whenPutListAndSortedListByNameLength() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>();
        users.addAll(
                Arrays.asList(
                        new User("Filipp", 25),
                        new User ("Zed", 15),
                        new User("Boris", 47),
                        new User("Asteriks", 34)
                )
        );

        sortUser.sortNameLength(users);
        assertThat(sortUser.sortNameLength(users).toString(), is(users.toString()));

        for(User s : users) {
            System.out.println(String.format("%s %s",s.getName(), s.getAge()));
        }
    }


    @Test
    public void whenPutListAndSortedListByAllFields() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>();
        users.addAll(
                Arrays.asList(
                        new User("Zed", 25),
                        new User ("Zed", 15),
                        new User ("Alex", 48),
                        new User("Boris", 47),
                        new User("Boris", 34)
                )
        );

        sortUser.sortByAllFields(users);
        assertThat(sortUser.sortByAllFields(users).toString(), is(users.toString()));

        for(User s : users) {
            System.out.println(String.format("%s %s",s.getName(), s.getAge()));
        }
    }

}