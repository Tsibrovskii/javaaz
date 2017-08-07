package ru.tsibrovskii.CollectionsFramework.TestTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс банка.
 */
public class Bank {

    public Map<User, List<Account>> userAcc = new HashMap<>();

    /**
     * Метод добавления юзера в банк.
     * @param user юзер.
     */
    public void addUser(User user) {
        userAcc.put(user, null);
    }

    /**
     * Метод удаления юзера из банка.
     * @param user юзер.
     */
    public void deleteUser(User user) {
        userAcc.remove(user);
    }

    /**
     * Метод добавления счета юзеру.
     * @param user юзер.
     * @param account счет.
     */
    public void addAccountToUser(User user, Account account) {
        if(userAcc.get(user) != null) {
            userAcc.get(user).add(account);
        } else {
            List<Account> accList = new ArrayList<>();
            accList.add(account);
            userAcc.put(user, accList);
        }
    }

    /**
     * Метод удаления счета у юзера.
     * @param user юзер.
     * @param account счет.
     */
    public void deleteAccountFromUser(User user, Account account) {
        userAcc.get(user).remove(account);
    }

    /**
     * Метод получения всех счетов пользователя.
     * @param user юзер.
     * @return счета пользвателя.
     */
    public List<Account> getUserAccounts (User user) {
        return userAcc.get(user);
    }

    /**
     * Метод перевода средства со счета одного юзера на счет другого юзера.
     * @param srcUser юзер, со счета которого переводятся средства.
     * @param srcAccount счет, с которого переводятся средства.
     * @param dstUser юзер, которому переводятся средства.
     * @param dstAccount счет, на который переводятся средства.
     * @param amount количество средства для операции перевода.
     * @return успешность операции.
     */
    public boolean transferMoney (User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {

        if(userAcc.containsKey(srcUser) && userAcc.get(srcUser) != null && userAcc.get(srcUser).contains(srcAccount)
                && userAcc.get(srcUser).get(userAcc.get(srcUser).indexOf(srcAccount)).value >= amount ) {
            userAcc.get(srcUser).get(userAcc.get(srcUser).indexOf(srcAccount)).value -= amount;
            userAcc.get(dstUser).get(userAcc.get(dstUser).indexOf(dstAccount)).value += amount;
            return true;
        } else {
            return false;
        }
    }

}
