package ru.tsibrovskii.start;

public class ValidateInput extends ConsoleInput {

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range); //вызов из родительского класса
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please, enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}
