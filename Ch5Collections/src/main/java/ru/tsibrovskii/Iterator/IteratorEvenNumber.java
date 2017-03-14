package ru.tsibrovskii.Iterator;

import java.util.Iterator;

/**
 * Класс итератора четного числа.
 */
public class IteratorEvenNumber implements Iterator {

    private final int[] values;
    private int position = 0;

    /**
     * Конструктор класса.
     * @param values массив значений.
     */
    public IteratorEvenNumber(int[] values) {
        this.values = values;
    }

    /**
     * Метод, проверяющий, имеются ли еще элементы в массиве.
     * @return да или нет.
     */
    public boolean hasNext() {
        for (int i = this.position; i < this.values.length; i++) {
            if (this.values[i] % 2 == 0) {
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
            if (this.values[i] % 2 == 0) {
                this.position = i + 1;
                return this.values[i];
            }
        }
        return null;
    }
}
