package ru.tsibrovskii.start;

import ru.tsibrovskii.models.*;

class EditItem implements UserAction {

    public int key() {
        return 2;
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please, enter the item's id: ");
        String name = input.ask("Please, enter the item's name: ");
        String desc = input.ask("Please, enter the item's desc: ");
        Item item = new Item(name, desc, 1); // заглушка
        item.setId(id);
        tracker.edit(item);
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Edit the item");  //форматор
    }
}

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[4];
    private int position = 0;

    /**
     * Конструктор класса <b>MenuTracker</b> по умолчанию
     */
    public MenuTracker() {
    }

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
    }

    /**
     * Метод, возвращающий массив действий.
     * @return <b>actions</b> - массив действий.
     */
    public UserAction[] getActions() {
        return actions;
    }

    public void addAction(UserAction action) {
        this.actions[position++] = action;
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem implements UserAction {
        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the task's name: ");
            String desc = input.ask("Please, enter the task's desc: ");
            tracker.add(new Item(name, desc, 1)); // заглушка
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item");  //форматор
        }
    }

    private class DeleteItem implements UserAction {
            public int key() {
                return 3;
            }

            public void execute(Input input, Tracker tracker) {
                String id = input.ask("Please, enter the item's id: ");
                tracker.deleteItem(id);
            }

            public String info() {
                return String.format("%s. %s", this.key(), "Delete item");
            }
    }

    private static class ShowItems implements UserAction {
        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                if (item != null) {
                    System.out.println(String.format("%s. %s", item.getId(), item.getName()));
                }
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");  //форматор???
        }
    }
}