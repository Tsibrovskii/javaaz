package ru.tsibrovskii.start;

import org.junit.Assert;
import org.junit.Test;
import ru.tsibrovskii.models.Item;

import static org.hamcrest.core.Is.is;

public class StartUITest {

    @Test
    public void whenChoose0ShouldAddNewItem() {

        StubInput input = new StubInput(new String[] {"0", "123", "456", "y"});
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();

        Assert.assertThat(tracker.findByDescription("456")[0].getName(), is("123"));
    }

    @Test
    public void whenChoose1ShouldPrintAllItems() {

        StubInput input = new StubInput(new String[] {"0", "123", "456", "y"});
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
        Item item = new Item("123", "456", tracker.getAll()[0].getCreate());
        item.setId(tracker.getAll()[0].getId());

        Assert.assertThat(tracker.getAll()[0].getName(), is(item.getName()));
    }

    @Test
    public void whenChoose2ShouldEditItem() {

        Tracker tracker = new Tracker();
        StubInput input = new StubInput(new String[] {"0", "123", "456", "y"});
        new StartUI(input, tracker).init();

        String idTest = tracker.getAll()[0].getId();

        input = new StubInput(new String[] {"2", idTest, "newName", "newDesc", "y"});
        new StartUI(input, tracker).init();

        Assert.assertThat(tracker.getAll()[0].getName(), is("newName"));
    }

    @Test
    public void whenChoose3ShouldDeleteItem() {

        Tracker tracker = new Tracker();
        StubInput input = new StubInput(new String[] {"0", "oneName", "oneDesc", "n", "0", "twoName", "twoDesc", "y"});
        new StartUI(input, tracker).init();

        String idTest = tracker.getAll()[0].getId();

        input = new StubInput(new String[] {"3", idTest, "y"});
        new StartUI(input, tracker).init();

        Assert.assertThat(tracker.getAll()[1].getName(), is("twoName"));
    }

    @Test
    public void whenChoose4ShouldFindItem() {

        Tracker tracker = new Tracker();
        StubInput input = new StubInput(new String[] {"0", "oneName", "oneDesc", "n", "0", "twoName", "twoDesc", "y"});
        new StartUI(input, tracker).init();

        Assert.assertThat(tracker.findByDescription("twoDesc")[0].getName(), is("twoName"));
    }

    @Test
    public void whenChoose5ShouldAddComment() {

        Tracker tracker = new Tracker();
        StubInput input = new StubInput(new String[] {"0", "oneName", "oneDesc", "n", "0", "twoName", "twoDesc", "y"});
        new StartUI(input, tracker).init();

        String idTest = tracker.getAll()[0].getId();
        input = new StubInput(new String[] {"5", idTest, "comment", "y"});
        new StartUI(input, tracker).init();

        Assert.assertThat(tracker.getAll()[0].comments[0].comment, is("comment"));
    }
}