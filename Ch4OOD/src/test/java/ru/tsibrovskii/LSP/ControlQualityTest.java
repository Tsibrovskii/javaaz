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
        stores.add(new WarehouseSecond());
        stores.add(new Refrigerator());
        stores.add(new Shop());
        stores.add(new Trash());
        stores.add(new Reproduction());

        //Должно попасть в Shop.
        Food milk = new Milk();
        milk.name = "milk";
        milk.createDate = new Date(currentTime - currentTime / 10);
        milk.expiryDate = new Date(currentTime + currentTime / 10);
        foods.add(milk);

        //Должен попасть в Warehouse.
        Food bread = new Bread();
        bread.name = "bread";
        bread.createDate = new Date(currentTime - currentTime / 100);
        bread.expiryDate = new Date(currentTime + currentTime / 10);
        foods.add(bread);

        //Должно попасть в Trash.
        Food meat = new Meat();
        meat.name = "meat";
        meat.createDate = new Date(currentTime - currentTime / 10);
        meat.expiryDate = new Date(currentTime - currentTime / 100);
        foods.add(meat);

        //Должно попасть в Warehouse.
        Food sourCream = new Milk();
        sourCream.name = "sourCream";
        sourCream.createDate = new Date(currentTime - currentTime / 100);
        sourCream.expiryDate = new Date(currentTime + currentTime / 10);
        foods.add(sourCream);

        //Должно попасть в WarehouseSecond.
        Food cheese = new Milk();
        cheese.name = "cheese";
        cheese.createDate = new Date(currentTime - currentTime / 100);
        cheese.expiryDate = new Date(currentTime + currentTime / 10);
        foods.add(cheese);

        //Должно попасть в Refrigerator.
        Food vegetable = new Vegetable();
        vegetable.name = "carrot";
        vegetable.createDate = new Date(currentTime - currentTime / 100);
        vegetable.expiryDate = new Date(currentTime + currentTime / 10);
        vegetable.isFreeze = true;
        foods.add(vegetable);

        //Должно попасть в Reproduction.
        Food beaf = new Meat();
        beaf.name = "meat";
        beaf.createDate = new Date(currentTime - currentTime / 10);
        beaf.expiryDate = new Date(currentTime - currentTime / 100);
        beaf.canReproduce = true;
        foods.add(beaf);

        ControlQuality controlQuality = new ControlQuality(foods, stores);
        controlQuality.moveFood();

        Assert.assertThat(stores.get(3).foods.get(0), is(milk));
        Assert.assertThat(stores.get(0).foods.get(0), is(bread));
        Assert.assertThat(stores.get(4).foods.get(0), is(meat));
        Assert.assertThat(stores.get(1).foods.get(0), is(cheese));
        Assert.assertThat(stores.get(2).foods.get(0), is(vegetable));
        Assert.assertThat(stores.get(5).foods.get(0), is(beaf));
    }
}
