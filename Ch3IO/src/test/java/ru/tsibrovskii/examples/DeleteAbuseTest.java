package ru.tsibrovskii.examples;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;

/**
 * Тестовый класс.
 */
public class DeleteAbuseTest {

    /**
     * Тестовый метод.
     * @throws IOException исключение.
     */
    @Test
    public void whenGiveInputStreamAndArrayOfAbuseWordsShouldMakeOutputStream() throws IOException {

        DeleteAbuse deleteAbuse = new DeleteAbuse();

        String[] abuse = new String[] {"one", "four"};
        ByteArrayInputStream in = new ByteArrayInputStream("onetwothreefourfiveonetwo\r\nonefourfive".getBytes());

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        String result = "twothreefivetwofive";

        deleteAbuse.dropAbuse(in, out, abuse);

        Assert.assertThat(out.toString(), is(result));
    }
}
