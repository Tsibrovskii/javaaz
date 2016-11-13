package ru.tsibrovskii.start;

import ru.tsibrovskii.models.*;

/**
 * Класс, предназначенный для редактирования заявки.
 */
class EditItem implements UserAction {

    /**
     * Метод, возвращающий ключ.
     * @return ключ.
     */
    public int key() {
        return 2;
    }

    /**
     * Метод, редактирующий заявку.
     * @param input - ввод пользователя, tracker - хранилище заявок.
     */
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please, enter the item's id: ");
        String name = input.ask("Please, enter the item's name: ");
        String desc = input.ask("Please, enter the item's desc: ");
        Item item = new Item(name, desc, System.currentTimeMillis());
        item.setId(id);
        tracker.edit(item);
    }

    /**
     * Метод, печатающий подсказку на экране.
     * @return подсказка.
     */
    public String info() {
        return String.format("%s. %s", this.key(), "Edit the item");
    }
}

/**
 * Класс, предназначенный для хранения и выполнения действий над заявками.
 */
public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[6];
    private int position = 0;

    /**
     * Конструктор класса <b>MenuTracker</b> по умолчанию
     */
    public MenuTracker() {
    }

    /**
     * Конструктор класса <b>MenuTracker</b>
     * @param input ввод пользователя, tracker - хранилище заявок.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для вызова действия.
     * @param key идентификатор (ключ) для конкретного действия.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Метод для заполнения массива действий.
     */
    public void fillActions() {
        this.actions[position++] = this.new AddItem();
        this.actions[position++] = new MenuTracker.ShowItems();
        this.actions[position++] = new EditItem();
        this.actions[position++] = this.new DeleteItem();
        this.actions[position++] = this.new FindItem();
        this.actions[position++] = this.new AddComment();
    }

    /**
     * Метод, возвращающий массив действий.
     * @return <b>actions</b> - массив действий.
     */
    public UserAction[] getActions() {
        return actions;
    }

    /**
     * Метод, добавляющий действие в массив действий.
     * @param action действие.
     */
    public void addAction(UserAction action) {
        this.actions[position++] = action;
    }

    /**
     * Метод, выводящий на экран меню действий.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Класс, предназначенный для добавления заявки.
     */
    private class AddItem implements UserAction {

        /**
         * Метод, возвращающий ключ.
         * @return ключ.
         */
        public int key() {
            return 0;
        }

        /**
         * Метод, добавляющий заявку.
         * @param input ввод пользователя, tracker - хранилище заявок.
         */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the task's name: ");
            String desc = input.ask("Please, enter the task's desc: ");
            tracker.add(new Item(name, desc, System.currentTimeMillis()));
        }

        /**
         * Метод, печатающий подсказку на экране.
         * @return подсказка.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item");
        }
    }

    /**
     * Класс, предназначенный для удаления заявки.
     */
    private class DeleteItem implements UserAction {

        /**
         * Метод, возвращающий ключ.
         * @return ключ.
         */
        public int key() {
            return 3;
        }

        /**
         * Метод, удаляющий заявку.
         * @param input ввод пользователя, tracker - хранилище заявок.
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the item's id: ");
            tracker.deleteItem(id);
        }

        /**
         * Метод, печатающий подсказку на экране.
         * @return подсказка.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }
    }

    /**
     * Класс, предназначенный для поиска заявки.
     */
    private class FindItem implements UserAction {

        /**
         * Метод, возвращающий ключ.
         * @return ключ.
         */
        public int key() {
            return 4;
        }

        /**
         * Метод, выполняющий поиск заявки.
         * @param input ввод пользователя, tracker - хранилище заявок.
         */
        public void execute(Input input, Tracker tracker) {
            String desc = input.ask("Please, enter part of the item's description: ");
            Item[] foundItem = tracker.findByDescription(desc);
            for (Item item : foundItem) {
                System.out.println(item.getName());
            }
        }

        /**
         * Метод, печатающий подсказку на экране.
         * @return подсказка.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Find item");
        }
    }

    /**
     * Класс, предназначенный для добавления комментария к заявке.
     */
    private class AddComment implements UserAction {

        /**
         * Метод, возвращающий ключ.
         * @return ключ.
         */
        public int key() {
            return 5;
        }

        /**
         * Метод, добавляющий комментарий к заявке.
         * @param input ввод пользователя, tracker - хранилище заявок.
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the item's id: ");
            Comment comm = new Comment();
            comm.comment = input.ask("Please, enter the item's commentarii: ");
            tracker.addComments(id, comm);
        }

        /**
         * Метод, печатающий подсказку на экране.
         * @return подсказка.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Add commentarii");
        }
    }

    /**
     * Класс, предназначенный для вывода на экран списка заявок.
     */
    private static class ShowItems implements UserAction {

        /**
         * Метод, возвращающий ключ.
         * @return ключ.
         */
        public int key() {
            return 1;
        }

        /**
         * Метод, печатающий список заявок на экран.
         * @param input ввод пользователя, tracker - хранилище заявок.
         */
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                if (item != null) {
                    System.out.print(item.toString());
                    for (Comment comm : item.comments) {
                        if (comm != null) {
                            System.out.print(comm.comment);
                            if (!comm.equals(item.comments[item.comments.length - 1])) {
                                System.out.print("; ");
                            }
                        }
                    }
                    System.out.println();
                }
            }
        }

        /**
         * Метод, печатающий подсказку на экране.
         * @return подсказка.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }
}