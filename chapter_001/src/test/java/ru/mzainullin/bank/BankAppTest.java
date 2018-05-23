package ru.mzainullin.bank;

import java.util.*;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Marat Zainullin
 * @since 17.05.2018
 */
public class BankAppTest {

    private static Bank bank;
    private static User userOne;
    private static User userTwo;
    private static Account accountOne;
    private static Account accountTwo;
    private static Account accountThree;


    @Before
    public void beforeTest() {
        bank = new Bank();
        userOne = new User("Alexander", "1234");
        userTwo = new User("Marat", "5678");
        bank.addUser(userOne);
        bank.addUser(userTwo);
        accountOne = new Account(100.0, "Alexander1234");
        accountTwo = new Account(50.0, "Marat5678");
    }


    @Test
    public void whenAddAccountToUserThenResultNewAccount() {
        bank.addAccountToUser("1234", accountOne);
        assertThat(bank.getUserAccounts("1234"), Matchers.is(Arrays.asList(accountOne)));
    }


    @Test
    public void whenDeleteAccountFromUser() {
        bank.addAccountToUser("1234", accountOne);
        bank.addAccountToUser("5678", accountTwo);
        bank.addUser(new User("newUser", "9998"));
        bank.addAccountToUser("9998", new Account(1500.0, "newUser9998"));

        for (List list  : bank.userListMap.values()) {
            for (Object obj : list) {
                System.out.println(obj);
            }
        }
        System.out.println();

        bank.deleteAccountFromUser("5678", accountTwo);
        assertThat(bank.getUserAccounts("1234"), Matchers.is(Arrays.asList(accountOne)));

        for (List list  : bank.userListMap.values()) {
            for (Object obj : list) {
                System.out.println(obj);
            }
        }
    }


    @Test
    public void whenAddUserToBank() {

        System.out.println("\n--- Список пользователей до добавления ---");
        for (User user  : bank.userListMap.keySet()) {
            System.out.println(String.format("%s, %s", user.getName(), user.getPassport()));
        }

        bank.addUser(new User("Ivan", "889"));
        accountThree = new Account(90.0, "Ivan889");
        bank.addAccountToUser("889", accountThree);

        assertThat(bank.getUserAccounts("889"), Matchers.is(Arrays.asList(accountThree)));

        System.out.println("\n--- Новый пользователь добавлен ---");
        for (User user  : bank.userListMap.keySet()) {
            System.out.println(String.format("%s, %s", user.getName(), user.getPassport()));
        }
    }


    @Test
    public void whenDeleteUserFromBank() {

        bank.addAccountToUser("1234", accountOne);
        bank.addAccountToUser("5678", accountTwo);

        for (User user  : bank.userListMap.keySet()) {
            System.out.println(String.format("%s, %s", user.getName(), user.getPassport()));
        }

        bank.deleteUser(userTwo);
        assertThat(bank.getUserAccounts(userOne.getPassport()), Matchers.is(Arrays.asList(accountOne)));

        System.out.println("\n--- После удаления пользователя ---");
        for (User user  : bank.userListMap.keySet()) {
            System.out.println(String.format("%s, %s", user.getName(), user.getPassport()));
        }
    }


    @Test
    public void whenTransferedMoneyFromFirstAccountToSecondAccount() {

        bank.addAccountToUser("1234", accountOne);
        bank.addAccountToUser("5678", accountTwo);

        System.out.println("--- Счета до транзакции ---");
        for (List list  : bank.userListMap.values()) {
            for (Object obj : list) {
                System.out.println(obj);
            }
        }

        bank.transferMoney("5678", "Marat5678", "1234", "Alexander1234", 30.0);
        assertThat(bank.getUserAccounts("1234"), is(Arrays.asList(accountOne)));

        System.out.println("\n--- Счета после транзакции ---");
        for (List list  : bank.userListMap.values()) {
            for (Object obj : list) {
                System.out.println(obj);
            }
        }
    }


    @Test
    public void whenShowAllUserAccounts() {
        bank.addAccountToUser("1234", accountOne);
        bank.addAccountToUser("5678", accountTwo);

        bank.getUserAccounts("5678");
        assertThat(bank.getUserAccounts(userTwo.getPassport()), Matchers.is(Arrays.asList(accountTwo)));

        bank.getUserAccounts("1234");
        assertThat(bank.getUserAccounts(userOne.getPassport()), Matchers.is(Arrays.asList(accountOne)));
    }


}
