package ru.tsibrovskii.Generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Тестовый класс.
 */
public class SimpleArrayTest {

    /**
     * Тестовый метод.
     */
    @Test
    public void whenCreateContainerShouldReturnCorrectType() {

        SimpleArray<String> simpleArray = new SimpleArray<String>(4);

        simpleArray.add("Test Value");
        String result = simpleArray.get(0);

        assertThat(result, is("Test Value"));
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenDeleteElementShouldSetNullValue() {

        SimpleArray<String> simpleArray = new SimpleArray<String>(4);

        simpleArray.add("Test Value");
        simpleArray.add("Second Value");

        simpleArray.delete(1);

        String result = simpleArray.get(1);

        assertTrue(result == null);
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenGivePositionAndElementShouldUpdateArray() {

        SimpleArray<String> simpleArray = new SimpleArray<String>(4);

        simpleArray.add("Test Value");
        simpleArray.add("Second Value");

        simpleArray.update(1, "New Value");

        String result = simpleArray.get(1);

        assertThat(result, is("New Value"));
    }
}
