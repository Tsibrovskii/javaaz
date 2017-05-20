package ru.tsibrovskii.LSP;

/**
 * Класс запасного склада.
 */
public class WarehouseSecond extends Store {

    public boolean putFood(Food food) {
        double expirationDate = (food.expiryDate.getTime() - System.currentTimeMillis()) / ((double) (food.expiryDate.getTime() - food.createDate.getTime()));
        if (expirationDate > 0.75 && !food.isFreeze) {
            foods.add(food);
            return true;
        } else {
            return false;
        }
    }
}
