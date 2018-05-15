package ru.mzainullin.bank;

import java.util.*;

/**
 * @author Marat Zainulin
 * @version 1.0
 * @sicne 15.05.2018
 */
public class Bank {

    /**
     * Список банковских счетов пользователей.
     */
    Map<User, List<Account>> userListMap;

    /**
     * Метод добавления пользователя.
     * @param user
     */
    public void addUser(User user) {}

    /**
     * Метод удаления пользователя.
     * @param user
     */
    public void deleteUser(User user) {}

    /**
     * Метод добавить счёт пользователю.
     * @param passport
     * @param account
     */
    public void addAccountToUser(String passport, Account account) {}

    /**
     * Метод удалить один счёт пользователя.
     * @param passport
     * @param account
     */
    public void deleteAccountFromUser(String passport, Account account) {}

    /**
     * Метод получить список счетов для пользователя.
     * @param passport
     */
    public List<Account> getUserAccounts (String passport) {}

    /**
     *  метод для перечисления денег с одного счёта на другой счёт
     * @param srcPassport
     * @param srcRequisite
     * @param destPassport
     * @param dstRequisite
     * @param amount
     * @return
     */
    public boolean transferMoney (String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        // если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.
    }



}

// Необходимо реализовать возможность перечислять деньги,
// как с одного счёта User на другой счёт того же User, так и на счёт другого User.
// Посмотрите на методы Map.putIfAbsent и List.indexOf, как их можно применить в этом задании.