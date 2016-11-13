package ru.tsibrovskii.start;

/**
 * Класс обработки ошибки при выходе значения из диапазона.
 */
public class MenuOutException extends RuntimeException {

    /**
     * Конструктор класса MenuOutException.
     * @param msg текст, вводимый пользователем.
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
