package ru.tsibrovskii.start;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.hamcrest.core.Is.is;

public class ValidateInputTest {

    @Test
    public void whenTakeQuestionAndRangeOfNumbersShouldReturnValue() {

        String inp = "2";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inp.getBytes());
        System.setIn(inputStream);

        ValidateInput validate = new ValidateInput();

        int[] range = new int[]{1, 2, 3};

        int i = Integer.valueOf(inp);

        Assert.assertEquals(validate.ask("Question", range), i);

    }
}