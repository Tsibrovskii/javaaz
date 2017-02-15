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
     * Метод, проводящий операции над числами.
     * @param firstNumber первое число.
     * @param secondNumber второе число.
     * @return результат.
     */
    double operation(final double firstNumber, final double secondNumber);
}
