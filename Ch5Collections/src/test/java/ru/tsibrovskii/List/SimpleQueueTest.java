package ru.tsibrovskii.List;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестовый класс.
 */
public class SimpleQueueTest {

    /**
     * Тестовый метод.
     */
    @Test
    public void whenPollElementShouldReturnAndDeleteIt() {

        SimpleQueue<String> simpleQueue = new SimpleQueue<String>();

        simpleQueue.add("first");
        simpleQueue.push("second");

        String result = simpleQueue.poll();

        assertThat(result, is("first"));
        assertThat(simpleQueue.getLength(), is(1));

    }
}
