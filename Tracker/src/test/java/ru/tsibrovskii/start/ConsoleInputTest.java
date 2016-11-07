package ru.tsibrovskii.start;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class ConsoleInputTest {

    @Test
    public void whenTakeQuestionReturnUserInput() {

        ByteArrayInputStream inputStream = new ByteArrayInputStream("y".getBytes());
        System.setIn(inputStream);

        ConsoleInput console = new ConsoleInput();

        Assert.assertEquals(console.ask("Question"), "y");
    }

    @Test
    public void whenTakeQuestionAndRangeOfNumbersShouldReturnKey() {

        String inp = "2";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inp.getBytes());
        System.setIn(inputStream);

        ConsoleInput console = new ConsoleInput();
        int[] range = new int[]{1, 2, 3};

        int i = Integer.valueOf(inp);

        Assert.assertEquals(console.ask("Question", range), i);
    }

    @Test (expected = MenuOutException.class)
    public void whenTakeQuestionAndRangeOfNumbersShouldReturnException() {

        String inp = "8";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inp.getBytes());
        System.setIn(inputStream);

        ConsoleInput console = new ConsoleInput();

        int[] range = new int[]{1, 2, 3};

        console.ask("Question", range);
    }
}