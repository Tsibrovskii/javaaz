package ru.tsibrovskii.SRP;

/**
 * Класс сложения чисел.
 */
public class SumOfNumbers implements ActionOfCalc {

    /**
     * Метод, возвращающий ключ для сложения чисел.
     * @return <b>1</b>.
     */
    public int key() {
        return 1;
    }

    /**
     * Метод, возвращающий информацию о действии.
     * @return информация.
     */
    public String information() {
        return String.format("%s. %s", this.key(), "Сложение.");
    }

    /**
     * Метод, складывающий 2 числа.
     * @param firstNumber первое число.
     * @param secondNumber второе число.
     * @return результат сложения.
     */
    public double operation (final double firstNumber, final double secondNumber) {
        return firstNumber + secondNumber;
    }
}
