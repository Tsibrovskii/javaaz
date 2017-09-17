package ru.tsibrovskii.Generic;

/**
 * Абстрактный класс хранилища.
 */
public abstract class AbstractStore<T extends Base> {

    public SimpleArray<T> store;
    public int size;

    /**
     * Метод добавления элемента.
     * @param u - элемент.
     */
    public void add(T u) {
        this.store.add(u);
    }

    /**
     * Метод обновления элемента.
     * @param Id - идентификатор элемента.
     * @param u - новый элемент.
     */
    public void update(String Id, T u) {
        for(int i = 0; i < size; i++) {
            if (Id.equals(store.get(i).getId())) {
                store.update(i, u);
                break;
            }
        }
    }

    /**
     * Метод удаления элемента из массива.
     * @param Id - идентификатор элемента.
     */
    public void delete(String Id) {
        for(int i = 0; i < size; i++) {
            if (Id.equals(store.get(i).getId())) {
                store.delete(i);
                break;
            }
        }
    }
}
