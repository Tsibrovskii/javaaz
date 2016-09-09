package ru.tsibrovskii.start;

import ru.tsibrovskii.models.*;

public class StartUI {

    private int[] ranges = new int[] {0, 1, 2, 3, 4}; // доработать, чтобы значение получалось из menu
    private Input input;

    public StartUI(Input input) {
        this.input = input;
    }

    public void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();

        do {
            menu.show();
            menu.select(input.ask("Select: ", ranges));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    public static void main(String[] args) {
        Input input = new ValidateInput();

        new StartUI(input).init();
    }
}
