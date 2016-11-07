package ru.tsibrovskii.start;

/**
 * Интерфейс получения ввода данных от пользователя.
 */
public interface Input {

    /**
     * Метод, возвращающий ввод пользователя.
     * @param question вопрос, задаваемый пользователю.
     * @return ввод пользователя.
     */
    String ask(String question);

    /**
     * Метод, возвращающий выбор пользователя.
     * @param question вопрос, задаваемый пользователю.
     * @param range диапазон значений
     * @return ввод пользователя или исключение.
     */
    int ask(String question, int[] range);

}
