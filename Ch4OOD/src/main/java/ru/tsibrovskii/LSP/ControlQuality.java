package ru.tsibrovskii.LSP;

import java.util.LinkedList;

/**
 * Класс контроля качества.
 */
public class ControlQuality {

    private LinkedList<Food> foods;
    private LinkedList<Store> stores;

    /**
     * Конструктор.
     * @param foods лист продуктов.
     */
    public ControlQuality(LinkedList<Food> foods, LinkedList<Store> stores) {
        this.foods = foods;
        this.stores = stores;
    }

    /**
     * Метод распределения продуктов.
     */
    public void moveFood() {
        for (Food food : this.foods) {
            for(Store store : this.stores) {
                if (store.putFood(food)) {
                    break;
                }
            }
        }
    }
}