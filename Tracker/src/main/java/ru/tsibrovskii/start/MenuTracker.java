package ru.tsibrovskii.start;

import ru.tsibrovskii.models.*;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[5];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void fillActions() {
        this.actions[0] = new AddItem();
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
            tracker.add(new Task(name, desc));
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item");  //форматор
        }
    }
}
