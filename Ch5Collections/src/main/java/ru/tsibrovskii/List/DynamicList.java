package ru.tsibrovskii.List;

import java.util.Iterator;

/**
 * Динамический контейнер
 */
public class DynamicList<E> implements SimpleContainer<E> {

    Object[] dynamicArray = new Object[100];
    public int index = 0;

    /**
     * Метод добавления нового элемента в массив.
     * @param e новый элемент.
     */
    public void add(E e) {
        if(index == this.dynamicArray.length) {
            Object[] arrayForCopy = new Object[this.dynamicArray.length * 2];
            for(int i = 0; i < this.dynamicArray.length; i++) {
                arrayForCopy[i] = this.dynamicArray[i];
            }
            this.dynamicArray = arrayForCopy;
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
                return position < dynamicArray.length;
            }

            public E next() {
                return (E) dynamicArray[position++];
            }

            @Override
            public void remove() {

            }
        };
    }
}
