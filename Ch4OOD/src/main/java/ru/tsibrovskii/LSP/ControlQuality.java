package ru.tsibrovskii.LSP;

import java.util.LinkedList;

/**
 * Класс контроля качества.
 */
public class ControlQuality {

    private LinkedList<Food> foods;
    public Warehouse warehouse;
    public Shop shop;
    public Trash trash;

    /**
     * Конструктор.
     * @param foods лист продуктов.
     */
    public ControlQuality(LinkedList<Food> foods) {
        this.foods = foods;
        this.warehouse = new Warehouse();
        this.shop = new Shop();
        this.trash = new Trash();
    }

    /**
     * Метод распределения продуктов.
     */
    public void moveFood() {
        for (Food food : this.foods) {
            double expirationDate = (food.expiryDate.getTime() - System.currentTimeMillis()) / ((double) (food.expiryDate.getTime() - food.createDate.getTime()));
            if (expirationDate > 0.75) {
                warehouse.foods.add(food);
            }
            if (expirationDate < 0.75 && expirationDate > 0.25) {
                shop.foods.add(food);
            }
            if (expirationDate < 0.25 && expirationDate > 0) {
                Food foodWithDiscount = food;
                foodWithDiscount.discount = 0.3;
                shop.foods.add(foodWithDiscount);
            }
            if (expirationDate <= 0) {
                trash.foods.add(food);
            }
        }
    }
}