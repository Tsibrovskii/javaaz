package ru.tsibrovskii.SRP;

import ru.tsibrovskii.OCP.RemadeMenuActions;

/**
 * Класс запуска приложения "Калькулятор".
 */
public class Calculator {

    private int[] ranges;
    private Input input;

    /**
     * Конструктор класса.
     * @param input экземпляр класса, предназначенного для получения ввода от пользователя.
     */
    public Calculator(Input input) {
        this.input = input;
    }

    /**
     * Метод заполнения массива элементами меню.
     */
    public void setRanges(MenuActions menuActions) {
        this.ranges = new int[menuActions.getActionOfCalc().length];
        for (int i = 0; i < this.ranges.length; i++) {
            this.ranges[i] = i + 1;
        }
    }

    /**
     * Метод общения с пользователем.
     */
    public void init(MenuActions menuActions) {
        do {
            menuActions.show();
            menuActions.selectAction(this.input.ask("Select: ", this.ranges));
            menuActions.printResult();
        } while (0 != this.input.ask("Exit?(0 - ноль): "));
    }

    /**
     * Метод запуска приложения.
     * @param args аргументы.
     */
    public static void main(String[] args) {
        Input input = new ValidateInput();
        MenuActions menuActions = new RemadeMenuActions(input, 7);
        menuActions.fillActions();
        Calculator calculator = new Calculator(input);
        calculator.setRanges(menuActions);
        calculator.init(menuActions);
    }
}
