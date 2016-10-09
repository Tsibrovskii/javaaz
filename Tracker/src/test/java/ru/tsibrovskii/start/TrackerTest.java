package ru.tsibrovskii.start;

import org.junit.*;
import ru.tsibrovskii.models.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTest {

    Item item = new Item("name", "desc", 1L);
    Comment commentarii = new Comment();
    Item[] resArray;
    Tracker tracker = new Tracker();

    @Before
    public void initilize() {
        commentarii.comment = "one";
        resArray = new Item[]{item};
    }


    @Test
    public void whenGiveItemShouldAddItInTheArray() {

        tracker.add(item);
        Item[] res = tracker.getAll();

        assertArrayEquals(res, resArray);
    }


    @Test
    public void whenAddCommentShouldGiveBackItemWithComment() {

        tracker.add(item);
        tracker.addComment(tracker.getAll()[0].getId(), commentarii);

        Assert.assertThat(tracker.getAll()[0].comments[0], is(commentarii));
    }
}
