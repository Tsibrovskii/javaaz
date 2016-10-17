package ru.tsibrovskii.start;

import ru.tsibrovskii.models.*;

/**
 * Класс предназначен для работы с классом <b>Tracker</b>
 */
public class StartUI {

    private int[] ranges;
    private Input input;

    /**
     * Метод заполнения массива <b>ranges</b>.
     */
    public void setRanges() {
        ranges = new int[new MenuTracker().getActions().length];
        for (int i = 0; i < ranges.length; i++) {
            ranges[i] = i;
        }
    }

    /**
     * Конструктор класса StartUI с входным параметром (вводом пользователя)
     * @param input ввод пользователя (целое число).
     */
    public StartUI(Input input) {
        this.input = input;
    }

    /**
     * Метод для выполнения действия над заявкой.
     */
    public void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();
        setRanges();

        do {
            menu.show();
            menu.select(input.ask("Select: ", ranges));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    /**
     * Метод запуска программы <b>Tracker</b>
     * При помощи объекта типа <b>Input</b> (ввод пользователя)
     * вызывается конструктор класса <b>StrartUI</b>
     */
    public static void main(String[] args) {
        Input input = new ValidateInput();

        new StartUI(input).init();
    }
}
