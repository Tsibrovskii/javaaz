package ru.tsibrovskii.Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Класс дерева.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    public Node<E> root;

    /**
     * Класс узла.
     * @param <E> тип.
     */
    public class Node<E> {

        List<Node<E>> children;
        E value;
    }

    /**
     * Метод добавления элемента в дерево.
     * @param parent parent - родительский элемент.
     * @param child child - дочерний элемент.
     * @return успешность операции.
     */
    @Override
    public boolean add(E parent, E child) {

        boolean isSuccessfully = true;

        if(parent == null || child == null || root.value.compareTo(child) == 0 || foundElement(root.children, child) != null) {
            isSuccessfully = false;
        }

        if(isSuccessfully && root.value.compareTo(parent) == 0) {
            Node<E> node = new Node<>();
            node.value = child;
            root.children.add(node);
        }

        if(isSuccessfully) {
            Node<E> parentElement = foundElement(root.children, parent);
            if(parentElement == null) {
                isSuccessfully = false;
            } else {
                Node<E> node = new Node<>();
                node.value = child;
                if(parentElement.children == null) {
                    parentElement.children = new ArrayList<>();
                }
                parentElement.children.add(node);
            }

        }

        return isSuccessfully;
    }

    /**
     * Метод добавления первого элемента в дерево.
     * @param parent первый элемент.
     */
    public void addFirst(E parent) {

        Node<E> node = new Node<>();
        node.value = parent;
        node.children = new ArrayList<>();

        root = node;
    }

    /**
     * Метод проверки на наличие объекта.
     * @param nodeList лист.
     * @param element элемент.
     * @return результат.
     */
    public Node<E> foundElement(List<Node<E>> nodeList, E element) {

        Node<E> foundElement = null;

        for(Node<E> n : nodeList) {
            if(n.value.compareTo(element) == 0) {
                foundElement = n;
                break;
            }
        }

        if(foundElement == null) {
            for (Node<E> n : nodeList) {
                if (n.children != null && foundElement(n.children, element) != null) {
                    foundElement = foundElement(n.children, element);
                    break;
                }
            }
        }

        return foundElement;

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
