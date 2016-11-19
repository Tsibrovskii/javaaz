package ru.tsibrovskii.start;

/**
 * Класс предназначен для работы с классом <b>Tracker</b>
 */
public class StartUI {

    private int[] ranges;
    private Input input;
    private Tracker tracker;

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
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для выполнения действия над заявкой.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
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
        Tracker tracker = new Tracker();

        new StartUI(input, tracker).init();
    }
}
