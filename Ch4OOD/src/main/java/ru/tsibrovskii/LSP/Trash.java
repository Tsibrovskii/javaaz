package ru.tsibrovskii.LSP;

/**
 * Класс отходов.
 */
public class Trash extends Store {

    public boolean putFood(Food food) {
        double expirationDate = (food.expiryDate.getTime() - System.currentTimeMillis()) / ((double) (food.expiryDate.getTime() - food.createDate.getTime()));
        if (expirationDate <= 0 && !food.canReproduce) {
            foods.add(food);
            return true;
        } else {
            return false;
        }

    }
}
