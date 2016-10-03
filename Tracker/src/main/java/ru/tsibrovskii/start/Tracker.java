package ru.tsibrovskii.start;

import ru.tsibrovskii.models.*;

import java.util.*;

/**
 * Класс <b>Tracker</b> для работы с заявками
 */
public class Tracker {

    private Item[] items = new Item[10];
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Метод для добавления заявки
     * @param item заявка
     */
    public void add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
    }

    /**
     * Метод для добавления комментария к заявке
     * @param item заявка
     * @param comment комментарий к заявке
     */
    public void addComment(Item item, Comment comment) {
        item.addComment(comment);
    }

    /**
     * Метод для изменения заявки
     * @param fresh новая заявка
     */
    public void edit(Item fresh) {
        for (int index = 0; index != items.length; ++index) {
            Item item = items[index];
            if (item != null && item.getId().equals(fresh.getId())) {
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
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    // Олег, это для меня, сюда не смотри)
    //добавить методы: редактировать, удалять, поиск по параметру (имя, описание, дата создания);
    //методы по добавлению комментариев к заявке (добавить модель коммент)
}