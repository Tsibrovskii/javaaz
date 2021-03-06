package ru.tsibrovskii.LSP;

/**
 * Класс магазина.
 */
public class Shop extends Store {

    public boolean putFood(Food food) {
        double expirationDate = (food.expiryDate.getTime() - System.currentTimeMillis()) / ((double) (food.expiryDate.getTime() - food.createDate.getTime()));
        if (expirationDate < 0.75 && expirationDate > 0) {
            if (expirationDate < 0.25) {
                food.discount = 0.3;
            }
            foods.add(food);
            return true;
        } else {
            return false;
        }
    }
}
