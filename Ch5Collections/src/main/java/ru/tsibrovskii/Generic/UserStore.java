package ru.tsibrovskii.Generic;

/**
 * Класс-хранилище юзеров.
 */
public class UserStore<User> extends AbstractStore {

    /**
     * Конструктор.
     * @param size - размер массива юзеров.
     */
    public UserStore(int size) {
        this.store = new SimpleArray<User>(size);
        this.size = size;
    }
}
