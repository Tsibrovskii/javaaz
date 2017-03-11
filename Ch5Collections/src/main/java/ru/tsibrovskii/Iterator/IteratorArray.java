package ru.tsibrovskii.Iterator;

import org.junit.Test;

import java.util.Iterator;

/**
 * Учебный класс.
 */
public class IteratorArray implements Iterator {

    private final int[] values;
    private int index = 0;

    public IteratorArray(final int[] values) {
        this.values = values;
    }

    public boolean hasNext() {
        return this.values.length > index;
    }

    public Object next() {
        return this.values[index++];
    }
}
