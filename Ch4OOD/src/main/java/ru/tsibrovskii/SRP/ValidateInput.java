package ru.tsibrovskii.SRP;

/**
 * Класс проверки ввода пользователя на корректность.
 */
public class ValidateInput extends ConsoleInput {

    /**
     * Метод проверки ввода пользователя на корректность.
     * @param question вопрос, задаваемый пользователю.
     * @param range диапазон возможных значений.
     * @return ввод пользователя.
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (OutOfRangesException ore) {
                System.out.println("Введите пункт из меню.");
            } catch (NumberFormatException nfe) {
                System.out.println("Введите числовое значение.");
            }
        } while (invalid);
        return value;
    }
}
