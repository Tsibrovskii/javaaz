package ru.tsibrovskii.List;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Тестовый класс.
 */
public class DynamicListTest {

    /**
     * Тестовый метод.
     */
    @Test
    public void whenAddElementShouldAddItInArray() {

        DynamicList<String> dynamicList = new DynamicList<String>();

        dynamicList.dynamicArray = new Object[1];

        dynamicList.add("first");
        dynamicList.add("second");

        String result = (String) dynamicList.dynamicArray[1];

        assertThat(result, is("second"));
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenGetIndexOfElementShouldReturnElement() {

        DynamicList<String> dynamicList = new DynamicList<String>();

        dynamicList.dynamicArray = new Object[1];

        dynamicList.add("first");
        dynamicList.add("second");

        String result = dynamicList.get(1);

        assertThat(result, is("second"));
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenUseIteratorShouldReturnTrue() {

        DynamicList<String> dynamicList = new DynamicList<String>();

        dynamicList.dynamicArray = new Object[1];

        dynamicList.add("first");
        dynamicList.add("second");

        Iterator<String> it = dynamicList.iterator();

        it.next();

        assertTrue(it.hasNext());
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenUseIteratorShouldReturnElement() {

        DynamicList<String> dynamicList = new DynamicList<String>();

        dynamicList.dynamicArray = new Object[1];

        dynamicList.add("first");
        dynamicList.add("second");

        Iterator<String> it = dynamicList.iterator();

        it.next();
        String result = it.next();

        assertThat(result, is("second"));
    }
}
