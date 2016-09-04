package ru.tsibrovskii.start;

import ru.tsibrovskii.models.*;

public class Tracker {

    public Item[] items = new Item[3];

    public static void main(String[] args) {
        Tracker tracker = new Tracker();

        tracker.items[0] = new Item("item", "desc", 0L);
        tracker.items[1] = new Task("task", "desc");
        tracker.items[2] = new Bug();

        for (Item item : tracker.items) {
            if (item instanceof Task) {
                System.out.println(((Task) item).calculatePrice());
            }
            System.out.println(item.getName() + " " + item.getDescription());
        }

    }
}
