package ru.tsibrovskii.LSP;

import java.util.LinkedList;

/**
 * Абстрактный класс для хранения товара.
 */
public abstract class Store {

    LinkedList<Food> foods = new LinkedList<Food>();

    /**
     * Метод помещения товара в хранилище.
     * @param food товар.
     * @return успешность операции.
     */
    abstract public boolean putFood(Food food);
}
