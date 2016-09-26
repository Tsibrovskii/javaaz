package ru.tsibrovskii.models;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void whenTakeNameandDescriptionandTimeShouldGiveThemBack() {

        Item item = new Item("name", "desc", 1L);

        String name = item.getName();

        Assert.assertThat(name, is("name"));

        String desc = item.getDescription();

        Assert.assertThat(desc, is("desc"));

        long time = item.getCreate();

        Assert.assertThat(time, is(1L));
    }

    @Test
    public void whenTakeIdShouldGiveItBack() {

        Item item = new Item();

        item.setId("this is id");

        String id = item.getId();

        Assert.assertThat(id, is("this is id"));
    }
}
