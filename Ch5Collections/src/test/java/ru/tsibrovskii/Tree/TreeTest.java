package ru.tsibrovskii.Tree;

import org.junit.Test;
import ru.tsibrovskii.Tree.Tree.Node;

import java.util.List;

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
        tree.add("first", "first");

        tree.add("second", "fourth");
        tree.add("second", "fifth");
        tree.add("second", "first");

        System.out.println("root " + tree.root.value);
        for (Node n : tree.root.children) {
            System.out.println(n.value);
            if(n.children != null) {
                for (Node m : (List<Node>)n.children) {
                    System.out.println(m.value);
                }
            }
        }

    }
}
