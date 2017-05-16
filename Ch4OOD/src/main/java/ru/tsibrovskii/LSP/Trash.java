package ru.tsibrovskii.LSP;

/**
 * Класс отходов.
 */
public class Trash extends Store {

    public boolean isHere(double expirationDate) {
        if (expirationDate <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void putFood(Food food) {
        foods.add(food);
    }
}
