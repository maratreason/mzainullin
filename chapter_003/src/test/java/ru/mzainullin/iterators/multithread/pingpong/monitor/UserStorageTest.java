package ru.mzainullin.iterators.multithread.pingpong.monitor;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 10.07.2018
 */
public class UserStorageTest {

    @Test
    public void transfer() {
        UserStorage storage = new UserStorage();
        User user1 = new User(1, 100);
        User user2 = new User(2, 200);

        storage.add(user1);
        storage.add(user2);
        storage.transfer(1, 2, 50);

        assertThat(storage.getUserMoney(user1), is(50));
        assertThat(storage.getUserMoney(user2), is(250));
    }

}