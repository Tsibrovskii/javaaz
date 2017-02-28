package ru.tsibrovskii.examples;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тестовый класс.
 */
public class HelloWorldTest {

    /**
     * Тестовый метод.
     */
    @Test
    public void whenRunShouldPrintHelloWorld() {
        // Система использует собственный поток.
        // класс HelloWorld печатает в объект out.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        HelloWorld.main(null);
        assertThat(out.toString(), is("Hello, World!!!!!"));
    }
}