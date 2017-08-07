package ru.tsibrovskii.TestTask;

import org.junit.Test;
import ru.tsibrovskii.CollectionsFramework.TestTask.Account;
import ru.tsibrovskii.CollectionsFramework.TestTask.Bank;
import ru.tsibrovskii.CollectionsFramework.TestTask.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тестовый класс.
 */
public class BankTest {

    /**
     * Тестовый метод.
     */
    @Test
    public void whenGiveUserShouldAddUserInTheMap() {

        Bank bank = new Bank();
        User user = new User("Ivan", "7000-142567");

        bank.addUser(user);

        User resultUser = null;

        for(User u : bank.userAcc.keySet()) {
            resultUser = u;
        }

        assertEquals(user, resultUser);
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenGiveUserShouldDeleteItFromMap() {

        Bank bank = new Bank();
        User user1 = new User("Ivan", "7000-142567");
        User user2 = new User("Lev", "7000-147867");

        bank.addUser(user1);
        bank.addUser(user2);

        bank.deleteUser(user1);

        assertFalse(bank.userAcc.containsKey(user1));
        assertTrue(bank.userAcc.containsKey(user2));
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenGiveUserAndAccountShouldAppendAccountToUser() {

        Bank bank = new Bank();
        User user = new User("Ivan", "7000-142567");

        bank.addUser(user);

        Account account = new Account(1000, "12345");

        bank.addAccountToUser(user, account);

        Account resAcc = null;
        for(Account acc : bank.userAcc.get(user)) {
            resAcc = acc;
        }

        assertEquals(resAcc, account);
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenGiveUserAndAccountShouldDeleteAccountFromUser() {

        Bank bank = new Bank();
        User user = new User("Ivan", "7000-142567");

        bank.addUser(user);

        Account account1 = new Account(1000, "12345");
        Account account2 = new Account(2000, "6789");

        bank.addAccountToUser(user, account1);
        bank.addAccountToUser(user, account2);

        bank.deleteAccountFromUser(user, account1);

        Account account = null;
        for(Account acc : bank.userAcc.get(user)) {
            account = acc;
        }

        assertEquals(account, account2);
        assertTrue(bank.userAcc.get(user).size() == 1);
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenGiveUserShouldReturnAllHisAccounts() {

        Bank bank = new Bank();
        User user = new User("Ivan", "7000-142567");

        bank.addUser(user);

        Account account1 = new Account(1000, "12345");
        Account account2 = new Account(2000, "6789");

        bank.addAccountToUser(user, account1);
        bank.addAccountToUser(user, account2);

        List<Account> accountList = new ArrayList<>();
        accountList.addAll(Arrays.asList(account1, account2));

        List<Account> resultAccList = bank.getUserAccounts(user);

        assertThat(resultAccList, is(accountList));
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenTransferResourcesShouldReturnResult() {

        Bank bank = new Bank();
        User ivan = new User("Ivan", "7000-142567");
        User lev = new User("Lev", "7000-148767");

        bank.addUser(ivan);
        bank.addUser(lev);

        Account accountIvan1 = new Account(1000, "12345");
        Account accountIvan2 = new Account(2000, "6789");
        Account accountLev1 = new Account(100, "777");
        Account accountLev2 = new Account(200, "888");

        bank.addAccountToUser(ivan, accountIvan1);
        bank.addAccountToUser(ivan, accountIvan2);
        bank.addAccountToUser(lev, accountLev1);
        bank.addAccountToUser(lev, accountLev2);

        Boolean firstTransaction = bank.transferMoney(ivan, accountIvan1, lev, accountLev1, 500);
        Boolean secondTransaction = bank.transferMoney(ivan, accountIvan2, lev, accountLev2, 3000);
        Boolean thirdTransaction = bank.transferMoney(ivan, new Account(2000, "678"), lev, accountLev2, 500);

        assertTrue(firstTransaction);
        assertFalse(secondTransaction);
        assertFalse(thirdTransaction);

        List<Account> accountList = new ArrayList<>();

        for(Account acc : bank.userAcc.get(ivan)) {
            accountList.add(acc);
        }
        assertEquals(accountList.get(0).value, 500);
        assertEquals(accountList.get(1).value, 2000);

        accountList.clear();
        for(Account acc : bank.userAcc.get(lev)) {
            accountList.add(acc);
        }
        assertEquals(accountList.get(0).value, 600);
        assertEquals(accountList.get(1).value, 200);

    }
}
