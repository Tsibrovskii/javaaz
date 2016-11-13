package ru.tsibrovskii.start;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class EditItemTest {

    EditItem edit = new EditItem();

    @Test
    public void whenRunTheMethodShouldReturnTheKey() {

        Assert.assertThat(edit.key(), is(2));
    }

    @Test
    public void whenRunInfoMethodShouldPrintTheHint() {

        Assert.assertThat(edit.info(), is(edit.key() + ". " + "Edit the item"));
    }

}
