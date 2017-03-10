package ru.tsibrovskii.SRP;

/**
 * Класс обработки ошибки при выходе значения из диапазона.
 */
public class OutOfRangesException extends RuntimeException {

    /**
     * Конструктор класса.
     * @param msg текст ошибки.
     */
    public OutOfRangesException(String msg) {
        super(msg);
    }
}
