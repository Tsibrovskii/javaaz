package ru.tsibrovskii.SRP;

/**
 * Класс для работы с операциями калькулятора.
 */
public class MenuCalc {

    private int position = 0;
    private ActionOfCalc[] actionOfCalc = new ActionOfCalc[5];

    public void fillTheMenu() {
        this.actionOfCalc[position++] = new SumOfNumbers();
    }

    public void showTheMenu() {
        for (ActionOfCalc act : actionOfCalc) {
            if (act != null) {
                System.out.println(act.information());
            }
        }
    }
}
