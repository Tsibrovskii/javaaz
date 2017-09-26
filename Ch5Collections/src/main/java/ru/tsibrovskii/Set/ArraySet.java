package ru.tsibrovskii.Set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс множества на массиве.
 */
public class ArraySet<E> implements SimpleSet<E> {

    Object[] dynamicArray = new Object[100];
    public int index = 0;

    /**
     * Метод добавления нового элемента в массив.
     * @param e новый элемент.
     */
    public void add(E e) {
        for (int i = 0; i < this.index; i++) {
            if(this.dynamicArray[i].equals(e)) {
                return;
            }
        }
        if(index == this.dynamicArray.length) {
            this.dynamicArray = Arrays.copyOf(this.dynamicArray, this.dynamicArray.length * 2);
        }
        this.dynamicArray[index++] = e;
    }

    /**
     * Метод получения элемента массива.
     * @param index индекс возвращаемого элемента.
     * @return запрашиваемый элемент.
     */
    public E get(int index) {
        return (E) this.dynamicArray[index];
    }

    /**
     * Метод итератора.
     * @return итератор.
     */
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            int position = 0;

            public boolean hasNext() {
                return position < index;
            }

            public E next() {
                if(position < index) {
                    return (E) dynamicArray[position++];
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}
