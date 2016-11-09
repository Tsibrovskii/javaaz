package ru.tsibrovskii.start;

import org.junit.Test;

public class MenuOutExceptionTest {

    @Test (expected = RuntimeException.class)
    public void whenThrowExceptionThenException() {
        throw new MenuOutException("");
    }
}
