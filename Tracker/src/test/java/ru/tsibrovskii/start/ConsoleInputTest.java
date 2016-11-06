package ru.tsibrovskii.start;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;

public class ConsoleInputTest {

    @Test
    public void whenTakeQuestionReturnUserInput() {

        ByteArrayInputStream inputStream = new ByteArrayInputStream("y".getBytes());
        System.setIn(inputStream);

        ConsoleInput console = new ConsoleInput();

        Assert.assertEquals(console.ask("Exit?(y): "), "y");
    }
}
