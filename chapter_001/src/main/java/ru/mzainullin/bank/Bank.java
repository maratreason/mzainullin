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


    /**
     * Метод добавления пользователя.
     * @param user - новый пользователь.
     */
    public void addUser(User user) {
        this.userListMap.putIfAbsent(user,  new ArrayList<>());
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
    public List<Account> getUserAccounts(String passport) {
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
     * @param destRequisite - в текущий реквизит.
     * @param amount - размер перечисленных денег.
     * @return - деньги перечислены true/false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean src = false;
        boolean dst = false;
        boolean trans = false;
        List<Account> srcList = getUserAccounts(srcPassport);
        List<Account> dstList = getUserAccounts(destPassport);

        for (Account account : srcList) {
            if (account.getRequisites().equals(srcRequisite)) {
                src = true;
                srcList = Arrays.asList(account);
            }
        }

        for (Account account : dstList) {
            if (account.getRequisites().equals(destRequisite)) {
                dst = true;
                dstList = Arrays.asList(account);
            }
        }

        if ((src && dst) && (srcList.get(0).transfer(dstList.get(0), amount))) {
            trans = true;
        }
        return trans;
    }

}