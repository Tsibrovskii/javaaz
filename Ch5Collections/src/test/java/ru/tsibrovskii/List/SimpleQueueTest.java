package ru.tsibrovskii.List;

import org.hamcrest.core.IsNull;
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

        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertThat((Integer) queue.poll(), is(1));
        assertThat((Integer) queue.poll(), is(2));
        assertThat((Integer) queue.poll(), is(3));
        assertThat((Integer) queue.poll(), is(IsNull.nullValue()));

    }
}
