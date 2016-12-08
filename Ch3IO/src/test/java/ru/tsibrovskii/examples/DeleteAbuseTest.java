package ru.tsibrovskii.examples;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

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

        ByteArrayOutputStream bOutput = new ByteArrayOutputStream(5);
        bOutput.write("one".getBytes());
        bOutput.write("two".getBytes());
        bOutput.write("three".getBytes());
        bOutput.write("four".getBytes());
        bOutput.write("five".getBytes());

        byte[] b = bOutput.toByteArray();

        InputStream in = new ByteArrayInputStream(b);
        OutputStream out = new ByteArrayOutputStream();
        OutputStream outTest = new ByteArrayOutputStream(3);
        outTest.write("two".getBytes());
        outTest.write("three".getBytes());
        outTest.write("five".getBytes());

        deleteAbuse.dropAbuse(in, out, abuse);

        Assert.assertThat(out, is(outTest));


    }
}
