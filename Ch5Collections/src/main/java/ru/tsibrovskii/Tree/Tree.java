package ru.tsibrovskii.Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Класс дерева.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    public List<Node<E>> nodes;

    /**
     * Класс узла.
     * @param <T> тип.
     */
    public class Node<T> {

        List<Node<T>> children;
        T value;
    }

    /**
     * Метод добавления элемента в дерево.
     * @param parent parent - родительский элемент.
     * @param child child - дочерний элемент.
     * @return успешность операции.
     */
    @Override
    public boolean add(E parent, E child) {

        boolean result = false;

        for (Node<E> n : nodes) {
            if(n.value.compareTo(parent) == 0) {

                Node<E> node = new Node<>();
                node.value = child;
                node.children = new ArrayList<>();
                nodes.add(node);

                n.children.add(node);

                result = true;
                break;
            }
        }

        return result;
    }

    /**
     * Метод добавления первого элемента в дерево.
     * @param parent первый элемент.
     */
    public void addFirst(E parent) {

        nodes = new ArrayList<>();

        Node<E> node = new Node<>();
        node.value = parent;
        node.children = new ArrayList<>();

        nodes.add(node);
    }

    /**
     * Метод итератора.
     * @return итератор.
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
