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
    Map<User, List<Account>> userListMap = new HashMap<>();
    /**
     * Метод добавления пользователя.
     * @param user
     */
    public void addUser(User user) {

    }

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
//    public List<Account> getUserAccounts (String passport) {
//    }

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
        return true;
    }

    public static void main(String[] args) {

        List<Account> newList = new ArrayList<>();
        newList.add(new Account("30000", "1230042132112321510"));
        newList.add(new Account("40000", "1230042132112321510"));

        Map<User, List<Account>> newMap = new HashMap<>();

        List<User> users = new ArrayList<>();
        users.add(new User("Ivan", "9304275748"));
        users.add(new User("Sonya", "9403275755"));

        for (int j = 0; j != users.size(); j++) {
            newMap.put(users.get(j), newList);
        }




        for (Map.Entry<User, List<Account>> user : newMap.entrySet()) {
            System.out.println(String.format("%s ", user));
        }

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