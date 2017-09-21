package ru.tsibrovskii.List;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Тествовый класс.
 */
public class ListTestTaskTest {

    /**
     * Тестовый метод.
     */
    @Test
    public void whenLinkedListIsCycleShouldReturnTrue() {

        ListTestTask<Integer> listTestTask = new ListTestTask();

        Node first =  new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;

        assertTrue(listTestTask.hasCycle(first));

    }
}
