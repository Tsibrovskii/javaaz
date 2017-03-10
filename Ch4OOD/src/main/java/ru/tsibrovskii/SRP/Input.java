package ru.tsibrovskii.SRP;

/**
 * Интерфейс получения ввода от пользователя.
 */
public interface Input {

    /**
     * Метод, получающий ввод от пользователя.
     * @param question вопрос, задаваемый пользователю.
     * @return ввод пользователя.
     */
    double ask(String question);

    /**
     * Метод, получающий ввод от пользователя.
     * @param question вопрос, задаваемый пользователю.
     * @param range диапазон возможных значений.
     * @return ввод пользователя или исключение.
     */
    int ask(String question, int[] range);
}
