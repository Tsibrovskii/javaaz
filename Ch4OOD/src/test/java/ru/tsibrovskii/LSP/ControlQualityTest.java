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

        Food milk = new Milk();
        milk.createDate = new Date(currentTime - currentTime / 10);
        milk.expiryDate = new Date(currentTime + currentTime / 10);
        foods.add(milk);

        Food bread = new Bread();
        bread.createDate = new Date(currentTime - currentTime / 100);
        bread.expiryDate = new Date(currentTime + currentTime / 10);
        foods.add(bread);

        Food meat = new Meat();
        meat.createDate = new Date(currentTime - currentTime / 10);
        meat.expiryDate = new Date(currentTime - currentTime / 100);
        foods.add(meat);

        ControlQuality controlQuality = new ControlQuality(foods);
        controlQuality.moveFood();

        Assert.assertThat(controlQuality.warehouse.foods.get(0), is(bread));
        Assert.assertThat(controlQuality.shop.foods.get(0), is(milk));
        Assert.assertThat(controlQuality.trash.foods.get(0), is(meat));
    }
}
