package ru.tsibrovskii.Iterator;

import java.util.Iterator;

/**
 * Итератор двухмерного массива.
 */
public class IteratorDoubleArray implements Iterator {

    private final int[][] values;
    private int i = 0;
    private int j = 0;

    /**
     * Конструктор класса.
     * @param values массив.
     */
    public IteratorDoubleArray(final int[][] values) {
        this.values = values;
    }

    /**
     * Метод, проверяющий, имеются ли еще элементы в массиве.
     * @return да или нет.
     */
    public boolean hasNext() {
        if (this.i == this.values.length && this.j == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Метод, возвращающий следующий элемент массива.
     * @return элемент массива.
     */
    public Object next() {
        try {
            int nextElement = this.values[i][j];
            if (this.j == this.values[i].length - 1) {
                this.j = 0;
                this.i++;
            } else {
                this.j++;
            }
            return nextElement;
        } catch (ArrayIndexOutOfBoundsException out) {
            return null;
        }
    }
}
