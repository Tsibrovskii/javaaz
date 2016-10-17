package ru.tsibrovskii.start;

import ru.tsibrovskii.models.*;

import java.util.*;

/**
 * Класс <b>Tracker</b> для работы с заявками
 */
public class Tracker {

    private Item[] items = new Item[1];
    private static final Random RN = new Random();

    /**
     * Метод для добавления заявки
     * @param item заявка
     */
    public void add(Item item) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == null) {
                this.items[i] = item;
                this.items[i].setId(generateId());
                return;
            }
        }
        Item[] bigitems = new Item[this.items.length + 1];
        for (int j = 0; j < items.length; j++) {
            bigitems[j] = items[j];
        }
        bigitems[items.length] = item;
        bigitems[items.length].setId(generateId());
        this.items = bigitems;
    }

    /**
     * Метод для добавления комментария к заявке
     * @param id <b>id</b> заявки
     * @param comment комментарий к заявке
     */
    public void addComments(String id, Comment comment) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId() == id) {
                items[i].addComment(comment);
            }
        }
    }

    /**
     * Метод для изменения заявки
     * @param fresh новая заявка
     */
    public void edit(Item fresh) {
        for (int index = 0; index != items.length; ++index) {
            if (items[index].getId().equals(fresh.getId())) {
                items[index] = fresh;
                break;
            }
        }
    }

    /**
     * Метод для поиска заявки по ее <b>id</b>
     * @param id <b>id</b> заявки
     * @return <b>Item</b> - искомая заявка
     */
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

    /**
     * Метод генерации случайного числа (<b>id</b>)
     * @return <b>id</b> - идентификатор заявки
     */
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    /**
     * Метод для получения массива заявок
     * @return <b>Item[]</b> - массив заявок
     */
    public Item[] getAll() {
        return items;
    }

    /**
     * Метод, удаляющий заявку.
     * @param id <b>id</b> заявки
     */
    public void deleteItem(String id) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = null;
            }
        }
    }

    /**
     * Метод, возвращающий массив заявок с учетом "фильтра"
     * @param desc фильтр
     * @return массив совпадений по "фильтру"
     */
    public Item[] findByDescription(String desc) {
        int numberOfCoincidence = 0;
        for (Item item : items) {
            if (item != null && item.getDescription().contains(desc)) {
                numberOfCoincidence++;
            }
        }

        int pos = 0;
        Item[] descItem = new Item[numberOfCoincidence];
        for (Item item : items) {
            if (item != null && item.getDescription().contains(desc)) {
                descItem[pos] = item;
                pos++;
            }
        }
        return descItem;
    }
}