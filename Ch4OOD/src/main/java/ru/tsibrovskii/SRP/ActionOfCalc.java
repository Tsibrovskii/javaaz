package ru.tsibrovskii.SRP;

/**
 * Интерфейс действий калькулятора.
 */
public interface ActionOfCalc {


    /**
     * Метод, печатающий информацию о действии.
     * @return информация для пользователя.
     */
    String information();

    /**
     * Метод, возвращающий ключ для выбранного действия.
     * @return ключ.
     */
    int key();

    /**
     * Метод, возвращающий ключ последнего выполненного действия.
     * @return ключ.
     */
    int setKey();

    /**
     * Метод, проводящий операции над числами.
     * @param input ввод пользователя.
     * @return результат операции.
     */
    double operation(Input input);

    /**
     * Метод, использующий результат последней операции.
     * @param input ввод пользователя.
     * @param result результат предыдущей операции.
     * @return результат операции.
     */
    default double operation(Input input, double result) {
        return -1;
    }
}
