package ru.tsibrovskii.Set;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестовый класс.
 */
public class LinkedSetTest {

    /**
     * Тестовый метод.
     */
    @Test
    public void whenAddElementShouldPutItInSet() {

        LinkedSet<String> linkedSet = new LinkedSet<>();

        linkedSet.add("one");
        linkedSet.add("one");
        linkedSet.add("two");

        Iterator<String> it = linkedSet.iterator();

        assertThat(linkedSet.getLength(), is(2));

        assertThat(it.next(), is("one"));
        assertThat(it.next(), is("two"));
    }
}
