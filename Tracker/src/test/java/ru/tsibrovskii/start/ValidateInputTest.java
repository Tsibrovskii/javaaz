package ru.tsibrovskii.start;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.hamcrest.core.Is.is;

public class ValidateInputTest {

    @Test (expected = MenuOutException.class)
    public void whenTakeQuestionAndRangeOfNumbersShouldReturnMenuOutException() {

        String inp = "7";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inp.getBytes());
        System.setIn(inputStream);

        ValidateInput validate = new ValidateInput();

        int[] range = new int[]{1, 2, 3};

        validate.ask("Question", range);
    }

    @Test
    public void whenTakeQuestionAndRangeOfNumbersShouldReturnNumberFormatException() {

        String inp = "a";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inp.getBytes());
        System.setIn(inputStream);

        ValidateInput validate = new ValidateInput();

        int[] range = new int[]{1, 2, 3};

        try {
            validate.ask("Question", range);
        } catch (NumberFormatException nfe) {
            Assert.assertThat(nfe.getMessage(), is(""));
        }
    }
}