package ru.tsibrovskii.Tree;

import java.util.Optional;

/**
 * Интерфейс дерева.
 */
public interface SimpleBinaryTree<E extends Comparable<E>> extends Iterable<E> {

    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     * @param element child.
     * @return
     */
    boolean add(E element);
}
