package ru.tsibrovskii.LSP;

/**
 * Класс переработки.
 */
public class Reproduction extends Trash {

    public boolean putFood(Food food) {
        double expirationDate = (food.expiryDate.getTime() - System.currentTimeMillis()) / ((double) (food.expiryDate.getTime() - food.createDate.getTime()));
        if (expirationDate <= 0 && food.canReproduce) {
            foods.add(food);
            return true;
        } else {
            return false;
        }
    }
}
