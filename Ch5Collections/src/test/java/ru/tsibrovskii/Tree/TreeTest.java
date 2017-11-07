package ru.tsibrovskii.Tree;

import org.junit.Test;

/**
 * Тестовый класс.
 */
public class TreeTest {

    @Test
    public void whenAddElementShouldPastItInCollection() {

        Tree<String> tree = new Tree<>();

        tree.addFirst("first");
        tree.add("first", "second");
        tree.add("first", "third");
        tree.add("second", "fourth");

        for (Tree.Node n : tree.nodes) {
            System.out.println(n.value);
        }
    }
}
