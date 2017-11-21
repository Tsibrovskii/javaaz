package ru.tsibrovskii.Tree;

import java.util.*;

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
        return new Iterator<E>() {

            boolean alreadyInit = false;
            Node<E> parent;
            E returnedElement;

            /**
             * Метод, проверяющий, есть ли еще элементы для возврата.
             * @return результат.
             */
            @Override
            public boolean hasNext() {
                boolean isHasNext = false;
                if(root.value != null) {
                    if(returnedElement == null) {
                        isHasNext = true;
                    } else {
                        isHasNext = !root.value.equals(returnedElement);
                    }
                }
                return isHasNext;
            }

            /**
             * Метод, возвращающий следующее значение.
             * @return значение.
             */
            @Override
            public E next() {

                boolean success = false;

                if(!hasNext()) {
                    throw new NoSuchElementException();
                }

                if(returnedElement == null) {
                    initReturnedElement(root);
                    success = true;
                }

                if(!success && returnedElement.equals(parent.value)) {
                    initParent(root);
                    initReturnedElement(parent);
                    success = true;
                }

                if(!success) {
                    boolean successInArray = false;
                    int index = -1;
                    for(Node n : parent.children) {
                        if(n.value.equals(returnedElement)) {
                            index = parent.children.indexOf(n);
                        }
                    }
                    if(parent.children.size() == index + 1) {
                        returnedElement = parent.value;
                        initParent(root);
                        successInArray = true;
                    }
                    if(!successInArray && parent.children.get(index + 1).children == null) {
                        returnedElement = parent.children.get(index + 1).value;
                        successInArray = true;
                    }
                    if(!successInArray) {
                        initReturnedElement(parent.children.get(index + 1));
                    }
                }

                return returnedElement;
            }

            /**
             * Метод определения следующего элемента для итератора.
             * Первым элементом будет элемент, расположенный левее остальных.
             * @param nodeElement начальный узел.
             */
            private void initReturnedElement(Node<E> nodeElement) {

                returnedElement = nodeElement.children == null || nodeElement.children.isEmpty() ? nodeElement.value : null;

                if(returnedElement == null) {
                    for (Node n : nodeElement.children) {
                        initReturnedElement(n);
                        if(returnedElement != null) {
                            if(!alreadyInit) {
                                parent = nodeElement;
                                alreadyInit = true;
                            }
                            break;
                        }
                    }
                }
            }

            /**
             * Метод определения родительского узла для дочернего элемента.
             * @param nodeElement возможный родительский узла.
             */
            private void initParent(Node<E> nodeElement) {

                if(nodeElement.children != null) {
                    for(Node n : nodeElement.children) {
                        if(n.value.equals(returnedElement)) {
                            parent = nodeElement;
                        }
                    }

                    if (parent == returnedElement) {
                        for (Node n : nodeElement.children) {
                            if (n != null) {
                                initParent(n);
                            }
                            if (parent != returnedElement) {
                                break;
                            }
                        }
                    }
                }

            }
        };
    }
}
