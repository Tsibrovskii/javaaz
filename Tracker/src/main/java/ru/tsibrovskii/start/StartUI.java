package ru.tsibrovskii.start;

import ru.tsibrovskii.models.*;

public class StartUI {

    private Input input;

    public StartUI(Input input) {
        this.input = input;
    }

    public void init() {
        String name = input.ask("Please, enter the task's name: ");
        Tracker tracker = new Tracker();
        tracker.add(new Task(name, "first desc"));
        for (Item item : tracker.getAll()) {
            System.out.println(item.getName());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();

        new StartUI(input).init();
    }
}
