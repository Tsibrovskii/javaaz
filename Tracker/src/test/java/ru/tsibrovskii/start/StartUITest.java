package ru.tsibrovskii.start;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class StartUITest {

    /*public static void main(String[] args) {
        Input input = new StubInput(new String[] {"create stub task"});

        new StartUI(input).init();
    }*/

    @Test
    public void whenChoise0ShouldAddNewItem() {

        Input input = new StubInput(new String[] {"1", "123", "456", "y"});
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();

        Assert.assertThat(tracker.getAll()[0].getName(), is("123"));
    }
}