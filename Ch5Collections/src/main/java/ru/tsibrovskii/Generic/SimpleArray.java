package ru.tsibrovskii.Generic;

/**
 * Класс контейнера.
 */
public class SimpleArray<T> {

    Object[] objects;
    int index = 0;

    /**
     * Конструктор класса.
     * @param size размер массива.
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * Метод печати элемента.
     * @param value входной параметр.
     * @param <K> тип входного параметра.
     * @return выходное значение.
     */
    public <K> K print(K value) {
        System.out.println(value);
        return value;
    }

    public void add(T value) {
        this.objects[index++] = value;
    }

    /**
     * Метод получения элемента из массива.
     * @param position позиция искомого элемента.
     * @return искомый элемент.
     */
    public T get(int position) {
        return (T) this.objects[position];
    }

    /**
     * Метод удаления элемента из массива.
     * @param position позиция удаляемого элемента.
     */
    public void delete(int position) {
        this.objects[position] = null;
    }

    /**
     * Метод обновления элемента массива.
     * @param position позиция обновляемого элемента.
     * @param value новое значение.
     */
    public void update(int position, T value) {
        this.objects[position] = value;
    }
}
