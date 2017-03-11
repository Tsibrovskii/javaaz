package ru.tsibrovskii.Iterator;

import java.util.Iterator;

/**
 * Итератор двухмерного массива.
 */
public class IteratorDoubleArray implements Iterator {

    private final int[][] values;
    private int[] arrayOfOneDimension;
    private int counter = 0;

    /**
     * Конструктор класса.
     * @param values массив.
     */
    public IteratorDoubleArray(final int[][] values) {
        this.values = values;
    }

    /**
     * Метод определения количества элементов массива.
     * @return длина одномерного массива.
     */
    private int setLengthOfArray() {
        int lenOfArray = 0;
        for (int i = 0; i < this.values.length; i++) {
            for (int j = 0; j < this.values[0].length; j++) {
                lenOfArray++;
            }
        }
        return lenOfArray;
    }

    /**
     * Метод заполнения нового одномерного массива.
     */
    public void convertArray() {
        this.arrayOfOneDimension = new int[setLengthOfArray()];
        for (int i = 0; i < this.values.length; i++) {
            for (int j = 0; j < this.values[0].length; j++) {
                this.arrayOfOneDimension[counter++] = this.values[i][j];
            }
        }
        this.counter = 0;
    }

    /**
     * Метод, проверяющий, имеются ли еще элементы в массиве.
     * @return да или нет.
     */
    public boolean hasNext() {
        return this.arrayOfOneDimension.length > this.counter;
    }

    /**
     * Метод, возвращающий следующий элемент массива.
     * @return элемент массива.
     */
    public Object next() {
        return this.arrayOfOneDimension[this.counter++];
    }
}
