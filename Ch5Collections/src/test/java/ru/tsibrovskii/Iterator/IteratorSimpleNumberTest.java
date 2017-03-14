package ru.tsibrovskii.Iterator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Тестовый класс.
 */
public class IteratorSimpleNumberTest {

    @Test
    public void whenGiveSimpleNumberShouldReturnTrue() {
        IteratorSimpleNumber iteratorSimpleNumber = new IteratorSimpleNumber(new int[] {1});

        boolean result = iteratorSimpleNumber.isSimpleNumber(7);

        assertTrue(result);
    }

    @Test
    public void whenGiveNotSimpleNumberShouldReturnFalse() {
        IteratorSimpleNumber iteratorSimpleNumber = new IteratorSimpleNumber(new int[] {1});

        boolean result = iteratorSimpleNumber.isSimpleNumber(15);

        assertFalse(result);
    }

    @Test
    public void whenGetNextShouldReturnFollowingSimpleElementOfArray() {
        IteratorSimpleNumber iteratorSimpleNumber = new IteratorSimpleNumber(new int[] {1, 5, 6, 9, 11, 13, 14});

        iteratorSimpleNumber.next();
        int result = (Integer) iteratorSimpleNumber.next();

        assertThat(result, is(11));
    }

    @Test
    public void whenCheckNextEvenElementOfArrayShouldReturnTrue() {
        IteratorSimpleNumber iteratorSimpleNumber = new IteratorSimpleNumber(new int[] {1, 5, 6, 9, 11, 13, 14});

        iteratorSimpleNumber.next();
        assertTrue(iteratorSimpleNumber.hasNext());
    }

    @Test
    public void whenCheckNextEvenElementOfArrayShouldReturnFalse() {
        IteratorSimpleNumber iteratorSimpleNumber = new IteratorSimpleNumber(new int[] {1, 5, 6, 9, 11, 13, 14});

        iteratorSimpleNumber.next();
        iteratorSimpleNumber.next();
        iteratorSimpleNumber.next();
        assertFalse(iteratorSimpleNumber.hasNext());
    }
}