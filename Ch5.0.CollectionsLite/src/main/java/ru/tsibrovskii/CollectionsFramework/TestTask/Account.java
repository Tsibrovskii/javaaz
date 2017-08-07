package ru.tsibrovskii.CollectionsFramework.TestTask;

/**
 * Класс аккаунта.
 */
public class Account {

    public int value;
    public String requisites;

    /**
     * Конструктор класса.
     * @param value сумма.
     * @param requisites банковский счет.
     */
    public Account(int value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (value != account.value) return false;
        return requisites != null ? requisites.equals(account.requisites) : account.requisites == null;
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (requisites != null ? requisites.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "value=" + value +
                ", requisites='" + requisites + '\'' +
                '}';
    }
}
