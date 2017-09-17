package ru.tsibrovskii.Generic;

/**
 * Класс-хранилище ролей.
 */
public class RoleStore<Role> extends AbstractStore {

    /**
     * Конструктор.
     * @param size - размер массива юзеров.
     */
    public RoleStore(int size) {
        this.store = new SimpleArray<Role>(size);
        this.size = size;
    }
}
