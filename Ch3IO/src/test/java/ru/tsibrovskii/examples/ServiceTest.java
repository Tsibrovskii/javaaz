package ru.tsibrovskii.examples;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Тестовый класс.
 */
public class ServiceTest {

    /**
     * Тестовый метод, должен вернуть false, когда вводим 1.
     * @throws IOException исключение.
     */
    @Test
    public void whenGiveOneShouldReturnFalse() throws IOException {

        Service service = new Service();

        ByteArrayInputStream bInput = new ByteArrayInputStream("1".getBytes());
        boolean res = service.isNumber(bInput);

        Assert.assertFalse(res);
    }

    /**
     * Тестовый метод, должен вернуть true, когда вводим 2.
     * @throws IOException исключение.
     */
    @Test
    public void whenGiveTwoShouldReturnFalse() throws IOException {

        Service service = new Service();

        ByteArrayInputStream bInput = new ByteArrayInputStream("2".getBytes());
        boolean res = service.isNumber(bInput);

        Assert.assertTrue(res);
    }


}
