package ru.tsibrovskii.Map;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Класс справочника.
 */
public class Handbook<T, V> {

    private T[] keys = (T[]) new Object[10];
    private V[] values = (V[]) new Object[this.keys.length];

    private int position = 0;

    /**
     * Метод вставки элемента в спровочник.
     * @param key ключ.
     * @param value значение.
     * @return успешность операции.
     */
    public boolean insert(T key, V value) {

        boolean containsKey = this.contains(key);

        if(!containsKey) {
            this.insertInArray(key, value);
        }
        return !containsKey;
    }

    /**
     * Метод получения значения.
     * @param key ключ.
     * @return значение.
     */
    public V get(T key) {

        V element = null;
        boolean containsKey = this.contains(key);

        if(containsKey) {
            element = this.getElement(key);
        }
        return element;
    }

    /**
     * Метод удаления элемента из справочника.
     * @param key ключ.
     * @return успешность операции.
     */
    public boolean delete(T key) {

        boolean containsKey = this.contains(key);

        if(containsKey) {

        }
        return containsKey;
    }

    /**
     * Метод проверки на наличие ключа в массиве ключей.
     * @param key ключ.
     * @return результат.
     */
    private boolean contains(T key) {
        boolean result = false;
        for (T k : this.keys) {
            if(k.equals(key)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод добавления элементов в массивы.
     * @param key ключ.
     * @param value значение.
     */
    private void insertInArray(T key, V value) {
        if(this.position == this.keys.length) {
            this.keys = Arrays.copyOf(this.keys, this.keys.length * 2);
            this.values = Arrays.copyOf(this.values, this.values.length * 2);
        }
        this.keys[this.position] = key;
        this.values[this.position] = value;
        this.position++;
    }

    /**
     * Метод получения значения по ключу.
     * @param key ключ.
     * @return значение.
     */
    private V getElement(T key) {
        int position = -1;
        for (T k : this.keys) {
            position++;
            if(k.equals(key)) {
                break;
            }
        }
        return this.values[position];
    }

    /**
     * Метод удаления ключи и значения из массивов.
     * @param key ключ.
     */
    //TODO
    private void deleteElement(T key) {
        int position = -1;
        for (T k : this.keys) {
            position++;
            if(k.equals(key)) {
                break;
            }
        }
    }
}
