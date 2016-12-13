package ru.tsibrovskii.examples;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;

/**
 * Тестовый класс.
 */
public class ServiceTest {

    /**
     * Тестовый метод, должен вернуть true, когда вводим четное число.
     * @throws IOException исключение.
     */
    @Test
    public void whenGiveDividedBy2ShouldReturnTrue() throws IOException {

        Service service = new Service();

        ByteArrayInputStream bInput = new ByteArrayInputStream("2\r\n3".getBytes());
        boolean res = service.isNumber(bInput);
        boolean assertValue = true;

        Assert.assertThat(res, is(assertValue));
    }

    /**
     * Тестовый метод, должен вернуть false, когда вводим нечетное число.
     * @throws IOException исключение.
     */
    @Test
    public void whenGiveNotDividedBy2ShouldReturnTrue() throws IOException {

        Service service = new Service();

        ByteArrayInputStream bInput = new ByteArrayInputStream("3\r\n3".getBytes());
        boolean res = service.isNumber(bInput);
        boolean assertValue = false;

        Assert.assertThat(res, is(assertValue));
    }



}
