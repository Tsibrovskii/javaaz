package ru.tsibrovskii.start;

import ru.tsibrovskii.models.*;

import java.util.*;

public class Tracker {

    private Item[] items = new Item[10];
    private int position = 0;
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if(item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    public Item[] getAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }


    //добавить методы: редактировать, удалять, поиск по параметру (имя, описание, дата создания);
    //методы по добавлению комментариев к заявке (добавить модель коммент)
    //добавить в Item переменную экземляра "коммент"
    //добавить метод add, который принимает только коммент
}