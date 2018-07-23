package ru.tsibrovskii.Synchronizy;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Динамический контейнер
 */
@ThreadSafe
public class DynamicList<E> implements SimpleContainer<E> {

    @GuardedBy("this")
    private Object[] dynamicArray = new Object[5];
    @GuardedBy("this")
    private int index = 0;

    /**
     * Метод добавления нового элемента в массив.
     * @param e новый элемент.
     */
    public synchronized void add(E e) {
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
    public synchronized E get(int index) {
        return (E) this.dynamicArray[index];
    }

    /**
     * Метод итератора.
     * @return итератор.
     */
    public synchronized Iterator<E> iterator() {
        return new Iterator<E>() {

            @GuardedBy("this")
            private int position = 0;

            public synchronized boolean hasNext() {
                return position < index;
            }

            public synchronized E next() {
                if(position < index) {
                    return (E) dynamicArray[position++];
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}
