package ru.mzainullin.iterators.generics;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Marat Zainullin
 * @since 26.05.2018
 */
public class StoreTest {

    private SimpleArray it;


    @Before
    public void setUp() {
        it = new SimpleArray(5);
    }


    @Test
    public void whenGenericIsUserAndExpectUserId() {
        SimpleArray<User> array = new SimpleArray<User>(5);
        array.add(new User("0"));
        array.add(new User("18"));
        array.add(new User("23"));

        User userOne = array.get(0);
        User userTwo = array.get(1);
        User userThree = array.get(2);

        assertThat(userOne.getId(), is("0"));
        assertThat(userTwo.getId(), is("18"));
        assertThat(userThree.getId(), is("23"));
    }


    @Test
    public void whenGenericIsRoleAndExpectRoleId() {
        SimpleArray<Role> array = new SimpleArray<Role>(4);
        array.add(new Role("1"));
        array.add(new Role("15"));
        array.add(new Role("10"));

        Role roleOne = array.get(0);
        Role roleTwo = array.get(1);
        Role roleThree = array.get(2);

        assertThat(roleOne.getId(), is("1"));
        assertThat(roleTwo.getId(), is("15"));
        assertThat(roleThree.getId(), is("10"));
    }


    @Test
    public void whenAddUserAndExpectNewUser() {
        SimpleArray<User> array = new SimpleArray<User>(5);
        array.add(new User("0"));
        array.add(new User("18"));

        User userOne = array.get(0);
        User userTwo = array.get(1);

        for (User user : array) {
            if (user != null)
                System.out.println(user.getId());
        }

        assertThat(userOne.getId(), is("0"));
        assertThat(userTwo.getId(), is("18"));
    }


    @Test
    public void whenDeleteUserAndExpectObjectWithoutDeletedUser() {
        SimpleArray<User> array = new SimpleArray<User>(5);
        array.add(new User("0"));
        array.add(new User("18"));
        array.add(new User("45"));
        array.add(new User("47"));

        System.out.println("Список объектов до удаления:");
        for (User user : array) {
            if (user != null)
                System.out.print(user.getId() + " ");
        }
        System.out.println("\n");
        array.delete(2);

        System.out.println("Список объектов после удаления объекта с индексом 2:");
        for (User user : array) {
            if (user != null)
                System.out.print(user.getId() + " ");
        }

        assertThat(array.get(0).getId(), is("0"));
        assertThat(array.get(1).getId(), is("18"));
        assertThat(array.get(2).getId(), is("47"));
    }


    @Test
    public void whenFindUserByIdAndReturnThatUser() {
        SimpleArray<Role> array = new SimpleArray<Role>(5);
        array.add(new Role("0"));
        array.add(new Role("18"));
        array.add(new Role("45"));
        array.add(new Role("47"));

        for (Role user : array) {
            if (user != null)
                System.out.println(user.getId());
        }

        RoleStore role = new RoleStore(array);
        Role result = role.findById("47");

        assertThat(result, is(array.get(3)));
    }


    @Test
    public void whenReplaceUserInsteadOfOldUser() {
        SimpleArray<Role> array = new SimpleArray<Role>(5);
        array.add(new Role("0"));
        array.add(new Role("18"));
        array.add(new Role("45"));

        System.out.println("Список объектов до перезаписи:");
        for (Role role : array) {
            if (role != null)
                System.out.print(role.getId() + " ");
        }
        System.out.println();

        RoleStore role = new RoleStore(array);
        boolean result = role.replace("18", new Role("23"));

        System.out.println("Список объектов после перезаписи объекта с индексом 1:");
        for (Role role1 : array) {
            if (role1 != null)
                System.out.print(role1.getId() + " ");
        }

        assertThat(result, is(true));
    }
}