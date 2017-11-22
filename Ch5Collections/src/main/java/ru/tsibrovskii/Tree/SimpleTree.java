package ru.tsibrovskii.Tree;

/**
 * Интерфейс дерева.
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {

    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     * @param parent parent.
     * @param child child.
     * @return
     */
    boolean add(E parent, E child);

    /**
     * Метод, проверяющий, является ли дерево бинарным.
     * @return результат проверки.
     */
    boolean isBinary();
}
