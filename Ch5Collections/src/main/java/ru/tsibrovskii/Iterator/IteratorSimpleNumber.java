package ru.tsibrovskii.Iterator;

import java.util.Iterator;

/**
 * Итератор простых чисел.
 */
public class IteratorSimpleNumber implements Iterator {

    private final int[] values;
    private int[] simpleArray;
    private int counter = 0;

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
     * Метод определения длины нового массива простых чисел.
     * @return длина нового массива.
     */
    private int setLengthOfSimpleArray() {
        int lenOfArray = 0;
        for (int value : this.values) {
            if (isSimpleNumber(value)) {
                lenOfArray++;
            }
        }
        return lenOfArray;
    }

    /**
     * Метод заполнения массива простыми числами.
     */
    public void setSimpleArray() {
        this.simpleArray = new int[setLengthOfSimpleArray()];
        for (int value : this.values) {
            if (isSimpleNumber(value)) {
                this.simpleArray[counter++] = value;
            }
        }
        this.counter = 0;
    }

    /**
     * Метод, проверяющий, имеются ли еще элементы в массиве.
     * @return да или нет.
     */
    public boolean hasNext() {
        return this.simpleArray.length > this.counter;
    }

    /**
     * Метод, возвращающий следующий элемент массива.
     * @return элемент массива.
     */
    public Object next() {
        if (this.simpleArray.length != 0) {
            return this.simpleArray[counter++];
        } else {
            return null;
        }
    }
}
