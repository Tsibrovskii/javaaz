package ru.tsibrovskii.LSP;

/**
 * Класс склада.
 */
public class Warehouse extends Store {

    public boolean isHere(double expirationDate) {
        if (expirationDate > 0.75) {
            return true;
        } else {
            return false;
        }
    }

    public void putFood(Food food) {
        foods.add(food);
    }
}
