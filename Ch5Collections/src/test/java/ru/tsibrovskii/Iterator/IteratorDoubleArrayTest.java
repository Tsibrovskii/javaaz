package ru.tsibrovskii.Iterator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Тестовый класс.
 */
public class IteratorDoubleArrayTest {

    @Test
    public void whenGetNextShouldReturnFollowingElementOfArray() {
        IteratorDoubleArray iteratorDoubleArray = new IteratorDoubleArray(new int[][] {{1, 2}, {3, 4}});
        iteratorDoubleArray.convertArray();

        iteratorDoubleArray.next();
        int result = (Integer) iteratorDoubleArray.next();

        assertThat(result, is(2));
    }
}