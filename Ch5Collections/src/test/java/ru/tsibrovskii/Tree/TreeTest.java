package ru.tsibrovskii.Tree;

import org.junit.Test;
import ru.tsibrovskii.Tree.Tree.Node;

import java.util.Iterator;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Тестовый класс.
 */
public class TreeTest {

    /**
     * Тестовый метод.
     */
    @Test
    public void whenAddElementShouldPastItInCollection() {

        Tree<String> tree = new Tree<>();

        tree.addFirst("first");

        tree.add("first", "second");
        tree.add("first", "third");
        tree.add("first", "first");

        tree.add("second", "fourth");
        tree.add("second", "fifth");
        tree.add("second", "first");

        System.out.println("Order of iterator" + "\n");
        for (Node n : tree.root.children) {
            if(n.children != null) {
                for (Node m : (List<Node>)n.children) {
                    System.out.println(m.value);
                }
            }
            System.out.println(n.value);
        }
        System.out.println(tree.root.value);
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenCallHasNextShouldReturnTrueOrFalse() {

        Tree<String> tree = new Tree<>();

        tree.addFirst("first");

        tree.add("first", "second");
        tree.add("first", "third");
        tree.add("first", "first");

        tree.add("second", "fourth");
        tree.add("second", "fifth");
        tree.add("second", "first");

        Iterator<String> it = tree.iterator();

        boolean isHasNext = it.hasNext();
        assertTrue(isHasNext);

        it.next();
        isHasNext = it.hasNext();
        assertTrue(isHasNext);

        it.next();
        isHasNext = it.hasNext();
        assertTrue(isHasNext);

        it.next();
        isHasNext = it.hasNext();
        assertTrue(isHasNext);

        it.next();
        isHasNext = it.hasNext();
        assertTrue(isHasNext);

        it.next();
        isHasNext = it.hasNext();
        assertFalse(isHasNext);
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenCallHasNextShouldReturnNextElement() {

        Tree<String> tree = new Tree<>();

        tree.addFirst("first");

        tree.add("first", "second");
        tree.add("first", "third");
        tree.add("first", "first");

        tree.add("second", "fourth");
        tree.add("second", "fifth");
        tree.add("second", "first");

        Iterator<String> it = tree.iterator();

        String next = it.next();
        assertTrue("fourth".equals(next));

        next = it.next();
        assertTrue("fifth".equals(next));

        next = it.next();
        assertTrue("second".equals(next));

        next = it.next();
        assertTrue("third".equals(next));

        next = it.next();
        assertTrue("first".equals(next));
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenCreateBinaryTreeShouldReturnTrue() {


        Tree<String> tree = new Tree<>();

        tree.addFirst("first");

        tree.add("first", "second");
        tree.add("first", "third");

        tree.add("second", "fourth");
        tree.add("second", "fifth");

        boolean isBinary = tree.isBinary();
        assertTrue(isBinary);
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenCreateNotBinaryTreeShouldReturnFalse() {


        Tree<String> tree = new Tree<>();

        tree.addFirst("first");

        tree.add("first", "second");
        tree.add("first", "third");

        tree.add("second", "fourth");
        tree.add("second", "fifth");
        tree.add("second", "sixth");

        boolean isBinary = tree.isBinary();
        assertFalse(isBinary);
    }
}
