package ru.tsibrovskii.List;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестовый класс.
 */
public class SimpleStackTest {

    /**
     * Тестовый метод.
     */
    @Test
    public void whenPushElementShouldAddIt() {

        SimpleStack<String> simpleStack = new SimpleStack<String>();

        simpleStack.add("first");
        simpleStack.push("second");

        String result = simpleStack.get(1);

        assertThat(result, is("second"));
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenPollElementShouldReturnAndDeleteIt() {

        SimpleStack<String> simpleStack = new SimpleStack<String>();

        simpleStack.add("first");
        simpleStack.push("second");

        String result = simpleStack.poll();

        assertThat(result, is("second"));
        assertThat(simpleStack.getLength(), is(1));

    }
}
