package ru.tsibrovskii.Iterator;

import java.util.Iterator;

/**
 * Класс итератора четного числа.
 */
public class IteratorEvenNumber implements Iterator {

    private final int[] values;
    private int[] evenArray;
    private int counter = 0;

    /**
     * Конструктор класса.
     * @param values массив значений.
     */
    public IteratorEvenNumber(int[] values) {
        this.values = values;
    }

    /**
     * Метод определения количества элементов нового массива четных чисел.
     * @return длина массива.
     */
    private int setLengthOfEvenArray() {
        int lenOfArray = 0;
        for (int value : this.values) {
            if (value % 2 == 0) {
                lenOfArray++;
            }
        }
        return lenOfArray;
    }

    /**
     * Метод заполнения массива четных чисел.
     */
    public void setEvenArray() {
        this.evenArray = new int[setLengthOfEvenArray()];
        for (int value : this.values) {
            if (value % 2 == 0) {
                this.evenArray[this.counter++] = value;
            }
        }
        this.counter = 0;
    }

    /**
     * Метод, проверяющий, имеются ли еще элементы в массиве.
     * @return да или нет.
     */
    public boolean hasNext() {
        return this.evenArray.length > this.counter;
    }

    /**
     * Метод, возвращающий следующий элемент массива.
     * @return элемент массива.
     */
    public Object next() {
        if (this.evenArray.length != 0) {
            return this.evenArray[counter++];
        } else {
            return null;
        }
    }
}
