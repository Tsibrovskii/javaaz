package ru.tsibrovskii.Tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BinarySearchTreeTest {

    @Test
    public void WhenAddElementsShouldPlaceThemInRightOrder() {

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(10);
        binarySearchTree.add(11);
        binarySearchTree.add(8);
        binarySearchTree.add(9);
        binarySearchTree.add(14);

        Iterator<Integer> it = binarySearchTree.iterator();
        assertTrue(it.hasNext());
        assertThat(it.next(), is(10));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(11));
        assertThat(it.next(), is(9));
        assertThat(it.next(), is(14));
        assertFalse(it.hasNext());
    }
}
