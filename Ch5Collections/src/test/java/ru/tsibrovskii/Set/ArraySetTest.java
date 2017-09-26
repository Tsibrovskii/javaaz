package ru.tsibrovskii.Set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестовый класс.
 */
public class ArraySetTest {

    @Test
    public void whenAddElementShouldPutItInSet() {

        ArraySet<String> arraySet = new ArraySet<>();

        arraySet.add("one");
        arraySet.add("one");
        arraySet.add("two");

        Iterator<String> it = arraySet.iterator();

        assertThat(it.next(), is("one"));
        assertThat(it.next(), is("two"));
    }
}
