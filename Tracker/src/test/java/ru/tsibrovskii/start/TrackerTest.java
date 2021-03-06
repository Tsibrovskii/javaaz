package ru.tsibrovskii.start;

import org.junit.*;
import ru.tsibrovskii.models.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTest {

    @Test
    public void whenGiveItemShouldAddItInTheArray() {

        Tracker tracker = new Tracker();
        Item item1 = new Item("name", "desc", 1L);
        Item item2 = new Item("two", "two", 2L);
        tracker.add(item1);
        tracker.add(item2);

        Item[] resArray = new Item[]{item1, item2};
        Item[] res = tracker.getAll();

        assertArrayEquals(res, resArray);
    }

    @Test
    public void whenAddCommentShouldGiveBackItemWithComment() {

        Tracker tracker = new Tracker();
        Item item1 = new Item("name", "desc", 1L);
        Item item2 = new Item("two", "two", 2L);
        tracker.add(item1);
        tracker.add(item2);

        Comment commentarii = new Comment();
        commentarii.comment = "one";

        tracker.addComments(tracker.getAll()[0].getId(), commentarii);

        Assert.assertThat(tracker.getAll()[0].comments[0], is(commentarii));
    }

    @Test
    public void whenGiveIdShouldGiveItemBack() {

        Tracker tracker = new Tracker();
        Item item1 = new Item("name", "desc", 1L);
        Item item2 = new Item("two", "two", 2L);
        tracker.add(item1);
        tracker.add(item2);

        Assert.assertThat(tracker.getAll()[0], is(tracker.findById(tracker.getAll()[0].getId())));
    }

    @Test
    public void whenEditItemShoulGiveItBack() {

        Tracker tracker = new Tracker();
        Item item1 = new Item("name", "desc", 1L);
        Item item2 = new Item("two", "two", 2L);
        tracker.add(item1);
        tracker.add(item2);

        Item newItem = new Item("secondName", "secondDesc", 2L);
        newItem.setId(tracker.getAll()[0].getId());
        tracker.edit(newItem);

        Assert.assertThat(tracker.findById(newItem.getId()), is(newItem));
    }

    @Test
    public void whenGivePartOfDescriptionShouldGiveItemBack() {

        Tracker tracker = new Tracker();
        Item item1 = new Item("name", "desc", 1L);
        Item item2 = new Item("two", "two", 2L);
        tracker.add(item1);
        tracker.add(item2);

        Item[] resArray = new Item[]{item1};

        Assert.assertArrayEquals(resArray, tracker.findByDescription("esc"));
    }

    @Test
    public void whenGiveIdShouldDeleteItemAndGiveItemsBack() {

        Tracker tracker = new Tracker();
        Item item1 = new Item("name", "desc", 1L);
        Item item2 = new Item("two", "two", 2L);
        tracker.add(item1);
        tracker.add(item2);

        Item[] resArray = new Item[]{item1, null};

        tracker.deleteItem(item2.getId());

        Assert.assertThat(tracker.getAll(), is(resArray));

    }

}