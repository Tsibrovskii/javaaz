package ru.tsibrovskii.Iterator;

import java.util.Iterator;

/**
 * Итератор простых чисел.
 */
public class IteratorSimpleNumber implements Iterator {

    private final int[] values;
    private int position = 0;

    /**
     * Конструктор класса.
     * @param values массив.
     */
    public IteratorSimpleNumber(int[] values) {
        this.values = values;
    }

    /**
     * Метод, проверящий является ли число простым.
     * @param number проверяемое число.
     * @return результат проверки.
     */
    public boolean isSimpleNumber(int number) {
        boolean result = true;
        if (number > 1) {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }
        return result;
    }

    /**
     * Метод, проверяющий, имеются ли еще элементы в массиве.
     * @return да или нет.
     */
    public boolean hasNext() {
        for (int i = this.position; i < this.values.length; i++) {
            if (isSimpleNumber(this.values[i])) {
                this.position = i;
                return true;
            }
        }
        return false;
    }

    /**
     * Метод, возвращающий следующий элемент массива.
     * @return элемент массива.
     */
    public Object next() {
        for (int i = this.position; i < this.values.length; i++) {
            if (isSimpleNumber(this.values[i])) {
                this.position = i + 1;
                return this.values[i];
            }
        }
        return null;
    }
}
