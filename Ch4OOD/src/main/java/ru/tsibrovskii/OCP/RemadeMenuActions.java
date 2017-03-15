package ru.tsibrovskii.OCP;

import ru.tsibrovskii.SRP.ActionOfCalc;
import ru.tsibrovskii.SRP.Input;
import ru.tsibrovskii.SRP.MenuActions;

/**
 * Расширенный класс меню действий приложения "Калькулятор".
 */
public class RemadeMenuActions extends MenuActions {

    /**
     * Конструктор класса.
     * @param input ввод пользователя.
     * @param size размер массива.
     */
    public RemadeMenuActions(Input input, int size) {
        super(input, size);
    }

    /**
     * Метод, переопределяющий формат вывода меню на экран.
     * @param actionOfCalc выбранное действие из меню.
     */
    @Override
    public void showAction(ActionOfCalc actionOfCalc) {
        System.out.println("*** " + actionOfCalc.information());
    }
}
