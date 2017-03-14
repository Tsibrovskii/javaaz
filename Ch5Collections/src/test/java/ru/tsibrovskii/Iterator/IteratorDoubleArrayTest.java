package ru.tsibrovskii.Iterator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

/**
 * Тестовый класс.
 */
public class IteratorDoubleArrayTest {

    @Test
    public void whenOutOfArrayShouldReturnNull() {
        IteratorDoubleArray iteratorDoubleArray = new IteratorDoubleArray(new int[][] {{1, 2}, {3, 4}});

        iteratorDoubleArray.next();
        iteratorDoubleArray.next();
        iteratorDoubleArray.next();
        iteratorDoubleArray.next();

        assertThat(iteratorDoubleArray.next(), is(nullValue()));
    }

    @Test
    public void whenGetNextShouldReturnFollowingElementOfArray() {
        IteratorDoubleArray iteratorDoubleArray = new IteratorDoubleArray(new int[][] {{1, 2}, {3, 4}});

        iteratorDoubleArray.next();
        iteratorDoubleArray.next();
        int resutl = (Integer) iteratorDoubleArray.next();

        assertThat(resutl, is(3));
    }

    @Test
    public void whenGetFinishElementShouldReturnFalse() {
        IteratorDoubleArray iteratorDoubleArray = new IteratorDoubleArray(new int[][] {{1, 2}, {3, 4}});

        iteratorDoubleArray.next();
        iteratorDoubleArray.next();
        iteratorDoubleArray.next();
        iteratorDoubleArray.next();

        assertFalse(iteratorDoubleArray.hasNext());
    }

    @Test
    public void whenHaveNextElementShouldReturnTrue() {
        IteratorDoubleArray iteratorDoubleArray = new IteratorDoubleArray(new int[][] {{1, 2}, {3, 4}});

        iteratorDoubleArray.next();
        iteratorDoubleArray.next();
        iteratorDoubleArray.next();

        assertTrue(iteratorDoubleArray.hasNext());
    }
}