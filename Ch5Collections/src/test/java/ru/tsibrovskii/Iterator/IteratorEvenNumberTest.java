package ru.tsibrovskii.Iterator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Тестовый класс.
 */
public class IteratorEvenNumberTest {

    @Test
    public void whenGetNextShouldReturnFollowingEvenElementOfArray() {
        IteratorEvenNumber iteratorEvenNumber = new IteratorEvenNumber(new int[] {1, 2, 3, 4, 5});

        iteratorEvenNumber.setEvenArray();
        iteratorEvenNumber.next();
        int result = (Integer) iteratorEvenNumber.next();

        assertThat(result, is(4));
    }
}