package ru.tsibrovskii.examples.socket;

import java.io.IOException;

/**
 * Интерфейср действий пользователя.
 */
public interface UserActions {

    /**
     * Метод, возвращающий ключ для выбранного действия.
     * @return
     */
    int key();

    /**
     * Метод, печатающий информацию о выбранном действии.
     * @return
     */
    String info();

    /**
     * Метод, выполняющий выбранное действие.
     */
    void execute() throws IOException;
}
