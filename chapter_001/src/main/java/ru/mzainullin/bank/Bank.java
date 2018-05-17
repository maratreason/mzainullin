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
     * Метод для перечисления денег с одного счёта на другой счёт
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

        for (User user : userListMap.keySet()) {
            List<Account> newAccounts = new ArrayList<>();

            for (Account acnt : accounts) {
                // Вычислить аккаунт откуда снимаются деньги
                if (user.getPassport().equals(srcPassport)) {
                    if (acnt.equals(srcRequisite)) {
                        newAccounts.add(acnt);
                        srcMapUser.put(user, newAccounts);
                    }
                    // Вычислить аккаунт куда перечисляются деньги
                } else if (user.getPassport().equals(destPassport)) {
                    if (acnt.equals(dstRequisite)) {
                        newAccounts.add(acnt);
                        srcMapUser.put(user, newAccounts);
                    }
                }
            }

            for (User transferUser : srcMapUser.keySet()) {
                if (transferUser.getPassport().equals(srcPassport)) {
                    for (int i = 0; i != newAccounts.size(); i++) {
                        if (newAccounts.get(i).getValue().equals(srcRequisite)) {
                            int num = Integer.parseInt(newAccounts.get(i).getValue());
                            String result = new Double (num - amount).toString();
                            newAccounts.get(i).setValue(result);
                        }
                    }
                }
            }

            for (User transferUser : srcMapUser.keySet()) {
                if (transferUser.getPassport().equals(destPassport)) {
                    for (int i = 0; i != newAccounts.size(); i++) {
                        if (newAccounts.get(i).getValue().equals(dstRequisite)) {
                            int num = Integer.parseInt(newAccounts.get(i).getValue());
                            String result = new Double (num + amount).toString();
                            newAccounts.get(i).setValue(result);
                        }
                    }
                }
            }

            isTransfer = true;
        }
        return isTransfer;
    }

    public static void main(String[] args) {
        Map<User, List<Account>> someMap = new TreeMap<>();

        List<Account> someAccounts = new ArrayList<>();
        someAccounts.add(new Account("30000", "94543654623"));
        someAccounts.add(new Account("40000", "94543654623"));

        List<Account> secondAccounts = new ArrayList<>();
        secondAccounts.add(new Account("50000", "11113654623"));
        secondAccounts.add(new Account("40000", "11113654623"));

        someMap.put(new User("Irina", "8932341312"), someAccounts);
        someMap.put(new User("Ivan", "1152341314"), secondAccounts);

        for (User user : someMap.keySet()) {
            System.out.println(String.format("%s : %s", user, someMap.get(user)));
        }

        System.out.println("\n");

        Bank bank = new Bank();
        bank.transferMoney("1152341314", "11113654623",
                "8932341312", "94543654623", 12000.0);

        System.out.println("После транзакции:");
        for (User user : someMap.keySet()) {
            System.out.println(String.format("%s : %s", user, someMap.get(user)));
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

public boolean transferMoney (String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount)
 - метод для перечисления денег с одного счёта на другой счёт:
если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.

Посмотрите на методы Map.putIfAbsent и List.indexOf, как их можно применить в этом задании.

 */