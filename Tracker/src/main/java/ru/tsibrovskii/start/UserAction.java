package ru.tsibrovskii.start;

/**
 * Интерфейс действий, которые должна выполнять программа в зависимости от выбора пользователя.
 */
public interface UserAction {

    /**
     * Метод, возвращающий ключ.
     * @return ключ.
     */
    int key();

    /**
     * Метод, выполнящий действие над заявкой.
     * @param input - ввод пользователя, tracker - хранилище заявок.
     */
    void execute(Input input, Tracker tracker);

    /**
     * Метод, печатающий подсказку на экране.
     * @return подсказка.
     */
    String info();
}