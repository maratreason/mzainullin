package ru.mzainullin.bank;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Marat Zainullin
 * @since 17.05.2018
 */
public class BankAppTest {

    @Test
    public void whenOneAccountPadiToNextAccount() {
        Bank bank = new Bank();

        Map<User, List<Account>> userMoney = new TreeMap<>();

        List<Account> firstAccount = new ArrayList<>();
        firstAccount.add(new Account(30000.0, "94543654623"));
        firstAccount.add(new Account(40000.0, "94543654623"));

        List<Account> secondAccount = new ArrayList<>();
        secondAccount.add(new Account(50000.0, "11113654623"));
        secondAccount.add(new Account(45000.0, "11113654623"));

        userMoney.put(new User("Irina", "8932341312"), firstAccount);
        userMoney.put(new User("Ivan", "1152341314"), secondAccount);

        for (User user : userMoney.keySet()) {
            System.out.println(String.format("%s : %s", user, userMoney.get(user)));
        }

        assertThat(bank.transferMoney(
                "1152341314", "11113654623",
                "8932341312", "94543654623", 25000.0),
                is(userMoney.get(new User("Irina", "8932341312"))));
    }

}
