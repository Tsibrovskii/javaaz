package ru.tsibrovskii.LSP;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.is;

/**
 * Тестовый класс.
 */
public class ControlQualityTest {

    @Test
    public void whenGiveListOfFoodShouldDistribute() {

        long currentTime = System.currentTimeMillis();

        LinkedList<Food> foods = new LinkedList<>();
        LinkedList<Store> stores = new LinkedList<Store>();
        stores.add(new Warehouse());
        stores.add(new Shop());
        stores.add(new Trash());

        Food milk = new Milk();
        milk.name = "milk";
        milk.createDate = new Date(currentTime - currentTime / 10);
        milk.expiryDate = new Date(currentTime + currentTime / 10);
        foods.add(milk);

        Food bread = new Bread();
        bread.name = "bread";
        bread.createDate = new Date(currentTime - currentTime / 100);
        bread.expiryDate = new Date(currentTime + currentTime / 10);
        foods.add(bread);

        Food meat = new Meat();
        meat.name = "meat";
        meat.createDate = new Date(currentTime - currentTime / 10);
        meat.expiryDate = new Date(currentTime - currentTime / 100);
        foods.add(meat);

        ControlQuality controlQuality = new ControlQuality(foods, stores);
        controlQuality.moveFood();

        Assert.assertThat(stores.get(0).foods.get(0), is(bread));
        Assert.assertThat(stores.get(1).foods.get(0), is(milk));
        Assert.assertThat(stores.get(2).foods.get(0), is(meat));
    }
}
