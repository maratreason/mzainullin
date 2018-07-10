package ru.mzainullin.iterators.multithread.pingpong.monitor;

import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 10.07.2018
 */
@ThreadSafe
public class UserStorage {

    private List<User> users = new LinkedList<>();


    /**
     * Метод добавления пользователя.
     * @param user - пользователь
     * @return true / false
     */
    boolean add(User user) {
        return this.users.add(user);
    }

    /**
     * Метод обновления пользователя.
     * @param user - пользователь
     * @return true / false
     */
    boolean update(User user) {
        for (int index = 0; index != this.users.size(); index++){
            if (users.get(index).getId() == user.getId()) {
                users.remove(index);
                users.add(user);
            }
        }
        return true;
    }

    /**
     * Метод удаления пользователя.
     * @param user - пользователь
     * @return true / false
     */
    boolean delete(User user) {
        for (int index = 0; index != this.users.size(); index++){
            if (users.get(index).getId() == user.getId()) {
                users.remove(index);
            }
        }
        return true;
    }

    int getUserMoney(User user) {
        int money = 0;
        for (int index = 0; index != this.users.size(); index++){
            if (this.users.get(index).equals(user)) {
                money = this.users.get(index).getAmount();
            }
        }
        return money;
    }

    /**
     * Метод перевода денег
     * @param fromId - id пользователя, откуда снимаются деньги
     * @param toId - id пользователя, куда переводятся деньги
     * @param amount - сумма перевода
     */
    Object transfer(int fromId, int toId, int amount) {

        UserStorage userStorage = new UserStorage();

        for (int index = 0; index != this.users.size(); index++){

            int firstId;
            int secondId;

            if (users.get(index).getId() == fromId) {
                firstId = users.get(index).getAmount() - amount;
                users.get(index).setAmount(firstId);
                userStorage.update(users.get(index));

            }

            if (users.get(index).getId() == toId) {
                secondId = users.get(index).getAmount() + amount;
                users.get(index).setAmount(secondId);
                userStorage.update(users.get(index));
            }

        }
        return userStorage;
    }

}
