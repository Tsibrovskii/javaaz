package ru.tsibrovskii.LSP;

import java.util.LinkedList;

/**
 * Абстрактный класс для хранения товара.
 */
public abstract class Store {

    LinkedList<Food> foods = new LinkedList<Food>();

    /**
     * Метод проверки актуальности товара для этого хранилища.
     * @param expirationDate срок годности.
     * @return результат.
     */
    abstract boolean isHere(double expirationDate);

    /**
     * Метод помещения товара в хранилище.
     * @param food товар.
     */
    abstract public void putFood(Food food);
}
