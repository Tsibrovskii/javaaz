package ru.tsibrovskii.start;

import org.junit.*;
import ru.tsibrovskii.models.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTest {

    Item item1 = new Item("name", "desc", 1L);
    Item item2 = new Item("two", "two", 2L);
    Comment commentarii = new Comment();
    Item[] resArray1;
    Item[] resArray2;
    Item[] resArray3;
    Item[] resArray4;
    Tracker tracker = new Tracker();

    @Before
    public void initilize() {

        tracker.add(item1);
        tracker.add(item2);
        commentarii.comment = "one";
        resArray1 = new Item[]{item1, item2};
        resArray2 = new Item[]{item1};
        resArray3 = new Item[]{item1, null};
        resArray4 = new Item[]{null};
    }

    @Test
    public void whenGiveItemShouldAddItInTheArray() {

        Item[] res = tracker.getAll();

        assertArrayEquals(res, resArray1);
    }

    @Test
    public void whenAddCommentShouldGiveBackItemWithComment() {

        tracker.addComments(tracker.getAll()[0].getId(), commentarii);

        Assert.assertThat(tracker.getAll()[0].comments[0], is(commentarii));
    }

    @Test
    public void whenGiveIdShouldGiveItemBack() {

        Assert.assertThat(tracker.getAll()[0], is(tracker.findById(tracker.getAll()[0].getId())));
    }

    @Test
    public void whenEditItemShoulGiveItBack() {

        Item newItem = new Item("secondName", "secondDesc", 2L);
        newItem.setId(tracker.getAll()[0].getId());
        tracker.edit(newItem);

        Assert.assertThat(tracker.findById(newItem.getId()), is(newItem));
    }

    @Test
    public void whenGivePartOfDescriptionShouldGiveItemBack() {

        Assert.assertArrayEquals(resArray2, tracker.findByDescription("esc"));
    }

    @Test
    public void whenGiveIdShouldDeleteItemAndGiveItemsBack() {

        tracker.deleteItem(item2.getId());

        Assert.assertThat(tracker.getAll()[1], is(resArray4[0]));

    }
}