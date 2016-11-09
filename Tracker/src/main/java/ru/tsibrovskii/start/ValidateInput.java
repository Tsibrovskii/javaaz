package ru.tsibrovskii.start;

/**
 * Класс, предназначенный для проверки ввода пользователя на корректность.
 */
public class ValidateInput extends ConsoleInput {

    /**
     * Метод проверки корректности ввода пользователя.
     * @param question вопрос, задаваемый пользователю.
     * @param range диапазон значений
     * @return ввод пользователя, либо исключение.
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please, select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please, enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}
