package ru.tsibrovskii.Map;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Тестовый класс.
 */
public class HandbookTest {

    /**
     * Тестовый метод.
     */
    @Test
    public void whenInsertKeyAndValueShouldIncreaseMap() {

        Handbook<String, Integer> handbook = new Handbook<>();

        handbook.insert("key1", 1);
        handbook.insert("key2", 2);

        Integer result = handbook.getElement("key2");
        assertThat(result, is(2));
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenDeleteShouldDecreaseMap() {

        Handbook<String, Integer> handbook = new Handbook<>();

        handbook.insert("key1", 1);
        handbook.insert("key2", 2);
        handbook.insert("key1", 3);
        handbook.delete("key2");

        Integer result = handbook.getElement("key1");
        assertThat(result, is(1));
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenHasElementShouldReturnTrue() {

        Handbook<String, Integer> handbook = new Handbook<>();

        handbook.insert("key1", 1);
        handbook.insert("key2", 2);

        Iterator<Handbook.MapHandbook> iterator = handbook.iterator();

        iterator.next();
        assertTrue(iterator.hasNext());
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenHasNoElementShouldReturnFalse() {

        Handbook<String, Integer> handbook = new Handbook<>();

        handbook.insert("key1", 1);
        handbook.insert("key2", 2);

        Iterator<Handbook.MapHandbook> iterator = handbook.iterator();

        iterator.next();
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenRequireNextElementShouldReturnElement() {

        Handbook<String, Integer> handbook = new Handbook<>();

        handbook.insert("key1", 1);
        handbook.insert("key2", 2);

        Iterator<Handbook.MapHandbook> iterator = handbook.iterator();

        iterator.next();
        Handbook.MapHandbook mapHandbook = iterator.next();
        assertThat((Integer) mapHandbook.value, is(2));
    }
}
