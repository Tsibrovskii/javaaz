package ru.tsibrovskii.LSP;

/**
 * Класс холодильного склада.
 */
public class Refrigerator extends Store {

    public boolean putFood(Food food) {
        double expirationDate = (food.expiryDate.getTime() - System.currentTimeMillis()) / ((double) (food.expiryDate.getTime() - food.createDate.getTime()));
        if (expirationDate > 0.75 && food.isFreeze) {
            foods.add(food);
            return true;
        } else {
            return false;
        }
    }
}
