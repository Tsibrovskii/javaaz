package ru.tsibrovskii.LSP;

/**
 * Класс магазина.
 */
public class Shop extends Store {

    public boolean isHere(double expirationDate) {
        if (expirationDate < 0.75 && expirationDate > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void putFood(Food food) {
        double expirationDate = (food.expiryDate.getTime() - System.currentTimeMillis()) / ((double) (food.expiryDate.getTime() - food.createDate.getTime()));
        if (expirationDate < 0.25 && expirationDate > 0) {
            food.discount = 0.3;
        }
        foods.add(food);
    }
}
