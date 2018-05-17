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
    Map<User, List<Account>> userListMap = new TreeMap<>();

    List<Account> accounts;

    /**
     * Метод добавления пользователя.
     * @param user - новый пользователь.
     */
    public void addUser(User user) {
        this.userListMap.putIfAbsent(user, accounts);
    }


    /**
     * Метод удаления пользователя.
     * @param user - удаляемый пользователь.
     */
    public void deleteUser(User user) {
        this.userListMap.remove(user);
    }


    /**
     * Метод добавить счёт пользователю.
     * @param passport - номер паспорта
     * @param account - номер счёта.
     */
    public void addAccountToUser(String passport, Account account) {
        for (User user: this.userListMap.keySet()) {
            if (user.getPassport().equals(passport)) {
                this.userListMap.get(user).add(account);
            }
        }
    }


    /**
     * Метод удалить один счёт пользователя.
     * @param passport - номер паспорта.
     * @param account - номер счёта.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        for (User user : this.userListMap.keySet()) {
            if (user.getPassport().equals(passport)) {
                this.userListMap.get(user).remove(account);
            }
        }
    }


    /**
     * Метод получить список счетов для пользователя.
     * @param passport - номер паспорта.
     */
    public List<Account> getUserAccounts (String passport) {
        List<Account> currentAccount = new ArrayList<>();
        for (User user : this.userListMap.keySet()) {
            if (user.getPassport().equals(passport)) {
                currentAccount = this.userListMap.get(user);
            }
        }
        return currentAccount;
    }


    /**
     *  метод для перечисления денег с одного счёта на другой счёт
     * @param srcPassport - с какого паспорта перечислают деньги.
     * @param srcRequisite - с какого реквизита перечислают деньги.
     * @param destPassport - в текущий паспорт.
     * @param dstRequisite - в текущий реквизит.
     * @param amount - размер перечисленных денег.
     * @return - деньги перечислены true/false.
     */
    public boolean transferMoney (String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        // если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.
        boolean isTransfer = false;

        Map<User, List<Account>> srcMapUser = new HashMap<>();

        for (User user : users) {
            boolean fromAccount;
            boolean toAccount;

            // Вычислить откуда аккаунт откуда снимаются деньги
            if (user.getPassport().equals(srcPassport)) {
                for (Account acnt : accounts) {
                    if (acnt.equals(srcRequisite)) {
                        fromAccount = this.userListMap.get(user).contains(acnt);
                    }
                }
            }

            // Вычислить аккаунт куда перечисляются деньги
            if (user.getPassport().equals(destPassport)) {
                for (Account acnt : accounts) {
                    if (acnt.equals(dstRequisite)) {
                        toAccount = this.userListMap.get(user).contains(acnt);
                    }
                }
            }

            for (int index = 0; index != users.size(); index++) {

                getUserAccounts(users.get(index).getPassport()).transferMoney(fromAccount, toAccount, amount);
//                this.userListMap.get(user1).contains(account1)
//                        && this.treemap.get(user2).contains(account2)
//                        && getUserAccounts(user1, account1).transfer(
//                        getUserAccounts(user2, account2), amount);

            }

            isTransfer = true;
        }
        return isTransfer;
    }

}

// Необходимо реализовать возможность перечислять деньги,
// как с одного счёта User на другой счёт того же User, так и на счёт другого User.
// Посмотрите на методы Map.putIfAbsent и List.indexOf, как их можно применить в этом задании.


/*
Реализовать коллекцию Map для банка

Необходимо создать класс User с полями name, passport.

Добавить методы eqauls() hashCode()

Необходимо создать класс Account с полями value (кол-во денег), requisites (реквизиты счёта) - это банковский счёт.

Реализовать коллекцию Map <User, List<Account>>, обозначающую что у каждого пользователя может быть список банковских счетов.

Необходимо реализовать возможность перечислять деньги, как с одного счёта User на другой счёт того же User, так и на счёт другого User.

В программе должны быть методы:

public void addUser(User user) {} - добавление пользователя.

public void deleteUser(User user) {} - удаление пользователя.

public void addAccountToUser(String passport, Account account) {} - добавить счёт пользователю.

public void deleteAccountFromUser(String passport, Account account) {} - удалить один счёт пользователя.

public List<Accounts> getUserAccounts (String passport) {} - получить список счетов для пользователя.

public boolean transferMoney (String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) - метод для перечисления денег с одного счёта на другой счёт:
если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.

Посмотрите на методы Map.putIfAbsent и List.indexOf, как их можно применить в этом задании.

 */