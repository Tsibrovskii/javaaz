package ru.tsibrovskii.start;

/**
 * Класс обработки ошибки при выходе значения из диапазона.
 */
public class MenuOutException extends RuntimeException {

    public MenuOutException(String msg) {
        super(msg);
    }
}
