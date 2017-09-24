package ru.tsibrovskii.List;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Тестовый класс.
 */
public class DynamicLinkedListTest {

    /**
     * Тестовый метод.
     */
    @Test
    public void whenAddElementShouldAddItInArray() {

        DynamicLinkedList<String> dynamicLinkedList = new DynamicLinkedList<String>();

        dynamicLinkedList.add("first");
        dynamicLinkedList.add("second");

        String result = dynamicLinkedList.getFirst().getNext().getElement();

        String previousResult = dynamicLinkedList.getFirst().getNext().getPrevious().getElement();

        assertThat(result, is("second"));
        assertThat(previousResult, is("first"));
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenGetElementShouldReturnIt() {

        DynamicLinkedList<String> dynamicLinkedList = new DynamicLinkedList<String>();

        dynamicLinkedList.add("first");
        dynamicLinkedList.add("second");
        dynamicLinkedList.add("third");

        String result = dynamicLinkedList.get(2);

        assertThat(result, is("third"));
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenUseIteratorShouldReturnTrue() {

        DynamicLinkedList<String> dynamicLinkedList = new DynamicLinkedList<String>();

        dynamicLinkedList.add("first");
        dynamicLinkedList.add("second");

        Iterator<String> it = dynamicLinkedList.iterator();

        it.next();

        assertTrue(it.hasNext());
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenUseIteratorShouldReturnElement() {

        DynamicLinkedList<String> dynamicLinkedList = new DynamicLinkedList<String>();

        dynamicLinkedList.add("first");
        dynamicLinkedList.add("second");

        Iterator<String> it = dynamicLinkedList.iterator();

        it.next();
        String result = it.next();

        assertThat(result, is("second"));
    }

}
